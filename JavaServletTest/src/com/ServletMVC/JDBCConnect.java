/**
 * Java Connect SQLServer
 */
package com.ServletMVC;
import java.sql.*;

public class JDBCConnect {
	private String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String ConnectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=SQLServerTest"; 
	private String user = "sa";
	private String passwd = "Jmh8906146";
	
	public Connection Con = null;
	
	public JDBCConnect() throws Exception{
		
		Class.forName(JDriver);//¼ÇÔØÊý¾Ý¿â
		Con = DriverManager.getConnection(ConnectDB, user, passwd);
		
	}
}
