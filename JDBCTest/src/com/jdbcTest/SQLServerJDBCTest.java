/**
 * JDBC���ӳ���
 */
package com.jdbcTest;
import java.sql.*;

public class SQLServerJDBCTest {
	
	String jDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //���ݿ�����
	String ConnectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=SQLServerTest"; //���ݿ����Ӵ�
	String User = "sa";
	String Pswd = "Jmh8906146";
	Connection con = null;
	
	public SQLServerJDBCTest(){
		
		try {
			Class.forName(jDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("�������ݿ�����ʧ��!");
			e.printStackTrace();
		}
		System.out.println("********************�������ݿ�����ɹ�!********************");
		
		try{
			con = DriverManager.getConnection(ConnectDB, User, Pswd);
		} catch( Exception e){
			System.out.println("�������ݿ�ʧ��!");
			e.printStackTrace();
		}
		System.out.println("********************�������ݿ�ɹ�!********************");
	}

}
