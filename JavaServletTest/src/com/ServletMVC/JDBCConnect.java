/**
 * Java Connect SQLServer
 */
package com.ServletMVC;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

public class JDBCConnect {
	private String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String ConnectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=SQLServerTest"; 
	private String user = "sa";
	private String passwd = "Jmh8906146";
	
	public Connection Con = null;
	
	public JDBCConnect() throws Exception{
		
		//JDBC 方式连接
		/******************
		Class.forName(JDriver);//加载数据库
		Con = DriverManager.getConnection(ConnectDB, user, passwd);
		**********************/
		
		//连接池方式连接
		Context context = new InitialContext();//获取Context资源
		DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/SqlServer1"); //获取数据库资源
		System.out.println("使用JNDI连接");
		Con = ds.getConnection();
		
	}
}
