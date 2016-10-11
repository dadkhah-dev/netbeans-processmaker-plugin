/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.company.processmaker;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import static jdk.nashorn.internal.objects.NativeString.substring;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.Exceptions;

/**
 *
 * @author omid
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm(GooglePanel g) {
        initComponents();
        this.setLocationRelativeTo(null);
        gPanel = g;
        jComboBoxProcess = gPanel.getjComboBoxProcess();
        conf = Config.getInstance();

        jTextFieldIP.setText(conf.get("IP"));
        jTextFieldPort.setText(conf.get("Port"));
        jTextFieldUser.setText(conf.get("User"));
        jPasswordField.setText(conf.get("Password"));
        //jTextFieldDatabase.setText(conf.get("Database"));
        jTextFieldPath.setText(conf.get("Path"));
        
        jTextFieldIPRemote.setText(conf.get("remote_host"));
        jTextFieldPortRemote.setText(conf.get("remote_port"));
        jTextFieldUserRemote.setText(conf.get("remote_user"));
        jPasswordFieldRemote.setText(conf.get("remote_pass"));
        jTextFieldPathRemote.setText(conf.get("remote_path"));

        ImageIcon img = new ImageIcon(getClass().getResource("icon24.png"));
        this.setIconImage(img.getImage());

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextFieldUser = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jTextFieldPort = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldIP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxDatabases = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPath = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldIPRemote = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldPortRemote = new javax.swing.JTextField();
        jTextFieldUserRemote = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPasswordFieldRemote = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxDatabasesRemote = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldPathRemote = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();

        setTitle(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.title")); // NOI18N
        setAlwaysOnTop(true);
        setIconImage(getIconImage());
        setIconImages(null);
        setResizable(false);
        setSize(new java.awt.Dimension(305, 355));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextFieldUser.setText(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jTextFieldUser.text")); // NOI18N

        jPasswordField.setText(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jPasswordField.text")); // NOI18N

        jTextFieldPort.setText(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jTextFieldPort.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jLabel6.text")); // NOI18N

        jTextFieldIP.setText(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jTextFieldIP.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jLabel5.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jTextFieldPort, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldIP, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jLabel4.text")); // NOI18N

        jTextFieldPath.setText(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jTextFieldPath.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBoxDatabases, 0, 173, Short.MAX_VALUE)
                                .addGap(77, 77, 77))
                            .addComponent(jTextFieldPath)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDatabases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jPanel3.TabConstraints.tabTitle"), jPanel3); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jLabel7.text")); // NOI18N

        jTextFieldIPRemote.setText(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jTextFieldIPRemote.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jLabel8.text")); // NOI18N

        jTextFieldPortRemote.setText(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jTextFieldPortRemote.text")); // NOI18N

        jTextFieldUserRemote.setText(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jTextFieldUserRemote.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jLabel9.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jLabel10.text")); // NOI18N

        jPasswordFieldRemote.setText(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jPasswordFieldRemote.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton3, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel11, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jLabel11.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jLabel12.text")); // NOI18N

        jTextFieldPathRemote.setText(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jTextFieldPathRemote.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldUserRemote, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(jTextFieldPortRemote, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIPRemote, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldRemote))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxDatabasesRemote, 0, 173, Short.MAX_VALUE)
                                .addGap(77, 77, 77))
                            .addComponent(jTextFieldPathRemote))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDatabasesRemote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPathRemote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIPRemote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPortRemote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUserRemote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldRemote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jButton3))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab(org.openide.util.NbBundle.getMessage(MainForm.class, "MainForm.jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if (jComboBoxDatabases.getItemCount() == 0) {
            String msg = "Please first Connect to MySql Server !";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);

            return;
        }

        String IP = jTextFieldIP.getText();
        String Port = jTextFieldPort.getText();
        String User = jTextFieldUser.getText();
        String Password = jPasswordField.getText();

        if (IP.length() == 0 || Port.length() == 0) {

            String msg = "Please fill IP and Port Fields Corrctly!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);

            return;
        }

        try {

            jButton2.setEnabled(false);

            Class.forName("com.mysql.jdbc.Driver");

            String Database = String.valueOf(jComboBoxDatabases.getSelectedItem());

            Connection con = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + Port + "/" + Database, User, Password);

            Statement stmt = con.createStatement();

            String checkQuery = "SELECT COUNT(1)\n"
                    + "FROM information_schema.tables st\n"
                    + "WHERE st.TABLE_SCHEMA = '" + Database + "' AND (st.TABLE_NAME = 'process' || st.TABLE_NAME = 'content')";
            ResultSet rsCheck = stmt.executeQuery(checkQuery);

            rsCheck.next();
            String strRes = rsCheck.getString(1);
            if (Integer.valueOf(strRes) != 2) {
                String msg = "Not suitable Database!";
                NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                DialogDisplayer.getDefault().notify(nd);
                jButton2.setEnabled(true);
                return;
            }

            String Path = jTextFieldPath.getText();
            File f = new File(Path + "\\shared\\sites\\" + substring(Database, 3));

            if (f.exists() && f.isDirectory()) {
                // do no thing
            } else {
                String msg = "The Path is not Valid!";
                NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                DialogDisplayer.getDefault().notify(nd);

                jButton2.setEnabled(true);

                return;
            }

            conf.set("IP", IP);
            conf.set("Port", Port);
            conf.set("User", User);
            conf.set("Password", Password);
            conf.set("Database", Database);
            conf.set("Path", Path);
            conf.set("Access", "local");
            conf.store();

            String query = "SELECT c.CON_VALUE,p.PRO_UID\n"
                    + "FROM PROCESS p\n"
                    + "LEFT JOIN content c ON p.PRO_UID = c.CON_ID\n"
                    + "WHERE c.CON_LANG = 'fa' AND c.CON_CATEGORY = 'PRO_TITLE'\n"
                    + "ORDER BY c.CON_VALUE";
            ResultSet rs = stmt.executeQuery(query);

            if (jComboBoxProcess.getItemCount() != 0) {
                jComboBoxProcess.removeAllItems();
            }

            gPanel.allProcess = new ArrayList<Process>();
            jComboBoxProcess.addItem("Please Select One Process");
            while (rs.next()) {
                jComboBoxProcess.addItem(rs.getString(1));

                Process p = new Process();
                p.CON_VALUE = rs.getString(1);
                p.PRO_UID = rs.getString(2);

                gPanel.allProcess.add(p);
            }

            con.close();

            this.setVisible(false);
            jButton2.setEnabled(true);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            String msg = "Connection Details is not valid!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
            jButton2.setEnabled(true);
        } catch (MySQLSyntaxErrorException ex) {
            Exceptions.printStackTrace(ex);
            String msg = "Errot in connect to Mysql server!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
            jButton2.setEnabled(true);
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
            String msg = "Errot in connect to Mysql server!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
            jButton2.setEnabled(true);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            String msg = "Errot in connect to Mysql server!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
            jButton2.setEnabled(true);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String IP = jTextFieldIP.getText();
        String Port = jTextFieldPort.getText();
        String User = jTextFieldUser.getText();
        String Password = jPasswordField.getText();

        if (IP.length() == 0 || Port.length() == 0) {

            String msg = "Please fill IP and Port Fields Corrctly!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);

            return;
        }

        try {

            jButton1.setEnabled(false);

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + Port, User, Password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW DATABASES");

            if (jComboBoxDatabases.getItemCount() == 0) {

                while (rs.next()) {
                    jComboBoxDatabases.addItem(rs.getString(1));
                    jComboBoxDatabasesRemote.addItem(rs.getString(1));
                }

            }

            con.close();
            jButton1.setEnabled(true);
            
            String msg = "Connection is OK!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
            

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            String msg = "Connection Details is not valid!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
            jButton1.setEnabled(true);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            String msg = "Errot in connect to Mysql server!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
            jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:

        if (jComboBoxDatabases.getItemCount() == 0) {
            String msg = "Please first Connect to MySql Server !";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);

            return;
        }

        String IP = jTextFieldIP.getText();
        String Port = jTextFieldPort.getText();
        String User = jTextFieldUser.getText();
        String Password = jPasswordField.getText();

        if (IP.length() == 0 || Port.length() == 0) {

            String msg = "Please fill IP and Port Fields Corrctly!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);

            return;
        }

        try {

            jButton2.setEnabled(false);

            Class.forName("com.mysql.jdbc.Driver");

            String Database = String.valueOf(jComboBoxDatabasesRemote.getSelectedItem());

            Connection con = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + Port + "/" + Database, User, Password);

            Statement stmt = con.createStatement();

            String checkQuery = "SELECT COUNT(1)\n"
                    + "FROM information_schema.tables st\n"
                    + "WHERE st.TABLE_SCHEMA = '" + Database + "' AND (st.TABLE_NAME = 'process' || st.TABLE_NAME = 'content')";
            ResultSet rsCheck = stmt.executeQuery(checkQuery);

            rsCheck.next();
            String strRes = rsCheck.getString(1);
            if (Integer.valueOf(strRes) != 2) {
                String msg = "Not suitable Database!";
                NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                DialogDisplayer.getDefault().notify(nd);
                jButton2.setEnabled(true);
                return;
            }
             
            conf.set("remote_host",jTextFieldIPRemote.getText());
            conf.set("remote_port",jTextFieldPortRemote.getText());
            conf.set("remote_user",jTextFieldUserRemote.getText());
            conf.set("remote_pass",jPasswordFieldRemote.getText());
            conf.set("remote_path",jTextFieldPathRemote.getText());
            
            
            SSH ssh = SSH.getInstance();
            ssh.updateVariables();
            if ( ssh.testDir() ) {
                // do no thing
            } else {
                String msg = "Remote Access is not valid or path don't exist";
                NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                DialogDisplayer.getDefault().notify(nd);

                jButton2.setEnabled(true);

                return;
            }

            conf.set("IP", IP);
            conf.set("Port", Port);
            conf.set("User", User);
            conf.set("Password", Password);
            conf.set("Database", Database);
            conf.set("Access", "remote");
            conf.store();

            String query = "SELECT c.CON_VALUE,p.PRO_UID\n"
                    + "FROM PROCESS p\n"
                    + "LEFT JOIN content c ON p.PRO_UID = c.CON_ID\n"
                    + "WHERE c.CON_LANG = 'fa' AND c.CON_CATEGORY = 'PRO_TITLE'\n"
                    + "ORDER BY c.CON_VALUE";
            ResultSet rs = stmt.executeQuery(query);

            if (jComboBoxProcess.getItemCount() != 0) {
                jComboBoxProcess.removeAllItems();
            }

            gPanel.allProcess = new ArrayList<Process>();
            jComboBoxProcess.addItem("Please Select One Process");
            while (rs.next()) {
                jComboBoxProcess.addItem(rs.getString(1));

                Process p = new Process();
                p.CON_VALUE = rs.getString(1);
                p.PRO_UID = rs.getString(2);

                gPanel.allProcess.add(p);
            }

            con.close();

            this.setVisible(false);
            jButton2.setEnabled(true);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            String msg = "Connection Details is not valid!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
            jButton2.setEnabled(true);
        } catch (MySQLSyntaxErrorException ex) {
            Exceptions.printStackTrace(ex);
            String msg = "Error in connect to Mysql server!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
            jButton2.setEnabled(true);
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
            String msg = "Errot in connect to Mysql server!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
            jButton2.setEnabled(true);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            String msg = "Errot in connect to Mysql server!";
            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
            DialogDisplayer.getDefault().notify(nd);
            jButton2.setEnabled(true);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private GooglePanel gPanel;
    private javax.swing.JComboBox<String> jComboBoxProcess;
    private Config conf;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxDatabases;
    private javax.swing.JComboBox<String> jComboBoxDatabasesRemote;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JPasswordField jPasswordFieldRemote;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextFieldIP;
    private javax.swing.JTextField jTextFieldIPRemote;
    private javax.swing.JTextField jTextFieldPath;
    private javax.swing.JTextField jTextFieldPathRemote;
    private javax.swing.JTextField jTextFieldPort;
    private javax.swing.JTextField jTextFieldPortRemote;
    private javax.swing.JTextField jTextFieldUser;
    private javax.swing.JTextField jTextFieldUserRemote;
    // End of variables declaration//GEN-END:variables

}
