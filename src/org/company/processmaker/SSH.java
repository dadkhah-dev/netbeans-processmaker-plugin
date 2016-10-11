/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.company.processmaker;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeString.substring;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.Exceptions;

/**
 *
 * @author omid
 */
public class SSH {

    public SSH() {
        conf = Config.getInstance();

        Host = conf.get("remote_host");
        Port = parseInt(conf.get("remote_port"));
        User = conf.get("remote_user");
        Password = conf.get("remote_pass");
        Path = conf.get("remote_path");
        WorkSpace = substring(conf.get("Database"), 3);

    }

    public void updateVariables() {

        Host = conf.get("remote_host");
        Port = parseInt(conf.get("remote_port"));
        User = conf.get("remote_user");
        Password = conf.get("remote_pass");
        Path = conf.get("remote_path");
        WorkSpace = substring(conf.get("Database"), 3);

    }

    public Integer parseInt(String data) {
        Integer val = 0;
        try {
            val = Integer.parseInt(data);
        } catch (NumberFormatException nfe) {
        }
        return val;
    }

    private Config conf;

    String Host;
    int Port;
    String User;
    String Password;
    String Path;
    String WorkSpace;

    Session session = null;
    Channel channel = null;
    ChannelSftp channelSftp = null;
    JSch jsch = null;

    public boolean testDir() {

        boolean success = false;

        try {

            jsch = new JSch();

            if (channelSftp != null && channelSftp.isConnected()) {
                session.disconnect();
                channel.disconnect();
                channelSftp.quit();
            }

            session = jsch.getSession(User, Host, Port);
            session.setPassword(Password);

            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;

            String dir = Path + "/shared/sites/" + WorkSpace + "/";
            SftpATTRS attrs = channelSftp.lstat(dir);

            // if we dont have exception then return true
            success = true;

        } catch (JSchException ex) {
            logger.warning("ServerConstants.SFTP_REFUSED_CONNECTION, ex");
        } catch (Exception ex) {
            logger.warning("ServerConstants.ERROR, ex");
        } finally {
            if (channelSftp != null && channelSftp.isConnected()) {
                try {
                    session.disconnect();
                    channel.disconnect();
                    channelSftp.quit();
                    logger.info("ServerConstants.FTP_DISCONNECT");
                    
                } catch (Exception ioe) {

                    logger.warning("ServerConstants.FTP_NOT_DISCONNECT, ioe");
                }
            } else {
                logger.warning("ServerConstants.ERROR, ex");
            }
        }

        return success;
    }

    // this function just try to connect to host and download all relaetd dyna forms
    public boolean downlaodFiles() {

        boolean success = false;

        try {

            if (!filesToDownload.isEmpty()) {
                for (String fileDownloadName : filesToDownload) {
                    success = false;

                    String dir = Path + "/shared/sites/" + WorkSpace + "/";
                    String dest = conf.tmp + "remote/" + Host + "_" + Port + "/" + WorkSpace + "/xmlForms/" + fileDownloadName;

                    File directory = new File(dest);
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                    channel = getSession().openChannel("sftp");
                    channel.connect();
                    channelSftp = (ChannelSftp) channel;
                    channelSftp.get(dir + "xmlForms/" + fileDownloadName + ".xml", dest);
                    success = true;
                    if (success) {
                        logger.log(Level.INFO, "ServerConstants.DOWNLOAD_SUCCESS_MSG" + fileDownloadName + ".xml");
                    }

                }

                conf.set("local_tmp_for_remote", conf.tmp + "remote/" + Host + "_" + Port + "/" + WorkSpace + "/xmlForms/");

            } else {
                logger.log(Level.INFO, "ServerConstants.NO_FILES_TO_DOWNLOAD + ServerUtils.getDateTime()");
                success = true;
            }

        } catch (SftpException ex) {
            logger.log(Level.WARNING, "ServerConstants.FILE_DOWNLOAD_FAILED, ex");
        } catch (Exception ex) {
            logger.log(Level.WARNING, "ServerConstants.ERROR, ex");
        } finally {
            if (channelSftp != null && channelSftp.isConnected()) {
                try {
                    session.disconnect();
                    channel.disconnect();
                    channelSftp.quit();
                    logger.log(Level.INFO, "ServerConstants.FTP_DISCONNECT");
                } catch (Exception ioe) {
                    logger.log(Level.WARNING, "ServerConstants.FTP_NOT_DISCONNECT, ioe");
                }
            } else {
                logger.warning("ServerConstants.ERROR, ex");
            }
        }

        return success;
    }

    private Session getSession() throws Exception {
        try {
            ChannelExec testChannel = (ChannelExec) session.openChannel("exec");
            testChannel.setCommand("true");
            testChannel.connect();
            logger.warning("Session erfolgreich getestet, verwende sie erneut");

            testChannel.disconnect();
        } catch (Throwable t) {
            logger.info("Session kaputt. Baue neue.");
            session = jsch.getSession(User, Host, Port);
            session.setPassword(Password);

            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
        }
        return session;
    }

    // this function just try to connect to host and upload current dyna forms
    public boolean uplaodFile(String fileName) {

        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;
        boolean success = false;

        try {
            JSch jsch = new JSch();

            channel = getSession().openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;

            success = false;

            String dir = Path + "/shared/sites/" + WorkSpace + "/";
            String[] res = fileName.split("/");
            channelSftp.put(conf.tmp + "remote/" + Host + "_" + Port + "/" + WorkSpace + "/xmlForms/" + fileName + "/" + res[1] + ".xml", dir + "xmlForms/" + fileName + ".xml", ChannelSftp.OVERWRITE);
            success = true;
            if (success) {
                logger.info("ServerConstants.UPLOAD_SUCCESS_MSG" + fileName + ".xml");
            }
        } catch (JSchException ex) {
            //Exceptions.printStackTrace(ex);
            logger.warning("ServerConstants.SFTP_REFUSED_CONNECTION, ex");
        } catch (Exception ex) {
            //Exceptions.printStackTrace(ex);
            logger.warning("ServerConstants.ERROR, ex");
        } finally {
            if (channelSftp != null && channelSftp.isConnected()) {
                try {
                    session.disconnect();
                    channel.disconnect();
                    channelSftp.quit();
                    logger.log(Level.INFO, "ServerConstants.FTP_DISCONNECT");
                } catch (Exception ioe) {

                    logger.log(Level.WARNING, "ServerConstants.FTP_NOT_DISCONNECT, ioe");
                }
            } else {
                logger.warning("ServerConstants.ERROR, ex");
            }
        }

        return success;
    }

    private static final Logger logger = Logger.getLogger(SSH.class.getName());

    public void setFilesToDowonlaod(List<String[]> dynas) {

        filesToDownload = new ArrayList<String>();
        for (int i = 0; i < dynas.size(); i++) {
            String[] res_row = dynas.get(i);
            filesToDownload.add(res_row[3]);
        }

    }

    public List<String> getFilesToDowonlaod() {
        return filesToDownload;
    }

    List<String> filesToDownload;
    private static SSH instance;

    public static SSH getInstance() {
        if (instance == null) {
            instance = new SSH();
        }
        return instance;
    }

}
