/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.shoppingCartApi.conectionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Cristian
 */
@Component
public class ConectionBD {

    private final static Logger LOGGER = Logger.getLogger("Conection");
    private static Connection con = null;
    public static String urlDB;
    public static String username;
    public static String password;
    public static String driverDB;

    @Autowired
    public void SetUser(@Value("${spring.datasource.username}") String user) {
        username = user;
    }

    @Autowired
    public void SetUrl(@Value("${spring.datasource.url}") String urlD) {
        urlDB = urlD;
    }

    @Autowired
    public void SetPass(@Value("${spring.datasource.password}") String pass) {
        password = pass;
    }

    @Autowired
    public void SetDriver(@Value("${spring.datasource.Driver}") String driver) {
        driverDB = driver;
    }

    public ConectionBD() {
    }

    public static Connection getConnection() {
        try {
            if (con == null) {    // con esto determinamos cuando ﬁnalize el programa cerrar la conexion   
                Runtime.getRuntime().addShutdownHook(new CloseCon());
                Class.forName(driverDB);
                con = DriverManager.getConnection(urlDB, username, password);
                LOGGER.info("Hello!Singleton connected.");
            }
            return con;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error al crear la conexion", ex);
        }
    }

    static class CloseCon extends Thread {
        //metodo para cerrar la conexion 

        public void run() {
            try {
                Connection con = ConectionBD.getConnection();
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
    }
}
