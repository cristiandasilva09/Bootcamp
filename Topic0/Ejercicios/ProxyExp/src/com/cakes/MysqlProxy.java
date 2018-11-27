package com.cakes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MysqlProxy  extends PruebaProxy{
	public MysqlProxy() 
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public  Connection cnx=null;
	public   Connection MysqlProxy() throws SQLException,  ClassNotFoundException {
		
	
		
		if(cnx ==null) 
		{
		try {
			
	
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection("jdbc:mysql://localhost/java_mysql", "root", "");
			} catch (SQLException ex) {
			  throw new SQLException(ex);
			} catch (ClassNotFoundException ex) {
			throw new ClassCastException(ex.getMessage());
			}

			return cnx;

	}
		return cnx;

}
}
