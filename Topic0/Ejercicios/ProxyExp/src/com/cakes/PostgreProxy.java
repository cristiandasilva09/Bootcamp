package com.cakes;

import java.sql.*;

public class PostgreProxy extends PruebaProxy {
	public Connection con=null;
	public PostgreProxy() 
	{
		
	}
	public Connection PostgreProxy() throws ClassNotFoundException {
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(
			   "jdbc:postgresql://hostname:port/dbname","root", "");
		

		} catch (SQLException e) {

			System.out.println("Fallo en la conexion");
			e.printStackTrace();
			return con;

		}
		return con;
	}
}	