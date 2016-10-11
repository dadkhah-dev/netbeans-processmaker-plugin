/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.company.processmaker;

import java.util.List;

/**
 *
 * @author omid
 */
class Global {
    private static Global instance = null;
    public static Global getInstance() {
        if (instance == null) {
            instance = new Global();
        }
        return instance;
    }
    
    public List<String[]> getDyna(){
        return dyna;
    }
    
    public void setDyna(List<String[]> dyna){
        this.dyna = dyna;
    }
    
    //d.DYN_UID,c.CON_VALUE,d.DYN_TYPE,d.DYN_FILENAME
    private List<String[]> dyna;
}