import java.sql.*;
public class ConexionBD {
	
private static Connection con=null;

private ConexionBD() {
	
}
public static Connection getConnection() 
		  {      
		 try      
			  {         
				  if( con == null )
				  {    // con esto determinamos cuando ﬁnalize el programa cerrar la conexion   
					  Runtime.getRuntime().addShutdownHook(new CerrarCon());
					  String driver="com.mysql.jdbc.Driver";
			            String url="jdbc:mysql://localhost/java_mysql";
			            String usr="root";
			            String pwd="";
			           
					  Class.forName(driver);
					  con = DriverManager.getConnection(url,usr,pwd);
					  System.out.println("Hello! has conectado el Singleton.");
					}         
				  return con;
				}      
			  catch(Exception ex)
			  {         
				  ex.printStackTrace();
				  throw new RuntimeException("Error al crear la conexion",ex);
			   }
		}
		  static class CerrarCon extends Thread   
		  {       
			  //metodo para cerrar la conexion 
			  public void run()
			  {         
				  try         
				  {            
					  Connection con = ConexionBD.getConnection();
					  con.close();
				  }         
			  catch( Exception ex )
			  {            
				  ex.printStackTrace();
				  throw new RuntimeException(ex);
			  }
		  }
	}
	
}
