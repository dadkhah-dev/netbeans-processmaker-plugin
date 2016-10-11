/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.company.processmaker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author omid
 */
public class Config {

    private Properties config;
    InputStream input = null;
    OutputStream output = null;
    String path = "config.properties";
    
    // don't forget use / in end
    String tmp = System.getProperty("java.io.tmpdir")+"/processmaker/";

    public Config() {
        config = new Properties();
        instance = this;
        try {
            input = new FileInputStream(path);
            config.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void store() {
        try {
            output = new FileOutputStream(path);
            config.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public String get(String key) {
        
        try{
            return config.getProperty(key);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return "";
    }

    public void set(String key, String value) {
        config.setProperty(key, value);
    }

    private static Config instance;

    public static Config getInstance() {
         if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
    
    public String getXmlForms(){
        return config.getProperty("Path") + "\\shared\\sites\\workflow\\xmlForms\\";
    }
    
    public String getXmlFormsRemote(){
        return config.getProperty("remote_path") + "/shared/sites/workflow/xmlForms/";
    }
    
    public boolean isRemote(){
        if(this.get("Access").equals("remote"))
            return true;
        else
            return false;
    }

}
