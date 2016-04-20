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
		
		//JDBC ��ʽ����
		/******************
		Class.forName(JDriver);//�������ݿ�
		Con = DriverManager.getConnection(ConnectDB, user, passwd);
		**********************/
		
		//���ӳط�ʽ����
		Context context = new InitialContext();//��ȡContext��Դ
		DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/SqlServer1"); //��ȡ���ݿ���Դ
		System.out.println("ʹ��JNDI����");
		Con = ds.getConnection();
		
	}
}
