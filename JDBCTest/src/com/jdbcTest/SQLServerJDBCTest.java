/**
 * JDBC连接程序
 */
package com.jdbcTest;
import java.sql.*;

public class SQLServerJDBCTest {
	
	String jDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //数据库引擎
	String ConnectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=SQLServerTest"; //数据库连接串
	String User = "sa";
	String Pswd = "Jmh8906146";
	Connection con = null;
	
	public SQLServerJDBCTest(){
		
		try {
			Class.forName(jDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载数据库引擎失败!");
			e.printStackTrace();
		}
		System.out.println("********************加载数据库引擎成功!********************");
		
		try{
			con = DriverManager.getConnection(ConnectDB, User, Pswd);
		} catch( Exception e){
			System.out.println("连接数据库失败!");
			e.printStackTrace();
		}
		System.out.println("********************连接数据库成功!********************");
	}

}
