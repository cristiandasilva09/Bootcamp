package com.cakes;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
public class Conexion {
	private static String servidor="jdbc:mysql://localhost/java_mysql";
	private static String user="root";
	private static String pass="com.mysql.jdbc.Driver\"";
	private static String driver ="com.mysql.jdbc.Driver";
	private static Connection conexion;
	public Conexion() {
		try {
			Class.forName(driver);
			conexion= DriverManager.getConnection(servidor, user,pass);
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("Conexion fallida");
		}
	}
}
