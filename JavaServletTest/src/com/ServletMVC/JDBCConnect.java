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
		
		//JDBC 数据库连接
		/******************
		Class.forName(JDriver);//加载数据库
		Con = DriverManager.getConnection(ConnectDB, user, passwd);
		**********************/
		
		//JNDI连接池
		Context context = new InitialContext();//加载Context内容,相对server.xml 中context内容
		DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/SqlServer1"); //加载jndi-name
		System.out.println("使用JNDI方式");
		Con = ds.getConnection();
		
	}
}
