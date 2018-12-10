/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.mysql.conectmysql;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class NewMain {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       try{
           TestService test = new TestService();
          
           test.queryExcersice5();
       } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
}
}
