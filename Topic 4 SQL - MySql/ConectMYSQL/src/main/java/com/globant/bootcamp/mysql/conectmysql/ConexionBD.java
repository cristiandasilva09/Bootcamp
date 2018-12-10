/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.mysql.conectmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */

public class ConexionBD {
    private Connection conn;
    private static final String driver ="com.mysql.jdbc.Driver";
    private static final String user ="root";
    private static final String password ="";
    private static final String url ="jdbc:mysql://localhost:3306/high-school";
     
    public ConexionBD(){
        
    }
    
    public Connection Conection(){
        conn =null;
    try {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user,password);
        if(con!=null) {
            
        System.out.println("Conected!");
        return con;}
    }catch(ClassNotFoundException | SQLException e){
        System.out.println( e.getMessage());
       
    }
    return conn;
    } 
    
public Connection getConection(){
    return conn;
}
public static void close(Connection con) {
    try {
        con.close();
    } catch (Exception ex) {
    }
}
 
}


