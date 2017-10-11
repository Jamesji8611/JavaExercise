package com.myjavacode.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DataOpernation {
	
	private String jDriver= "com.mysql.jdbc.Driver";
	private String DBinfo= "jdbc:mysql://127.0.0.1:3306/mysqljames";
	private String User= "root";
	private String Passwd= "root";
	
	private static Connection con = null;
	private ResultSet rs =null;
	
	public DataOpernation() {  //构造方法没有任何的返回类型
		
		try {
			Class.forName(jDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Init DB failed!");
		}
		
		try {
			con = (Connection) DriverManager.getConnection(DBinfo, User, Passwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection DB failed, check your user or passwd!");
		}
		
		System.out.println("DB Connection Succeed");
		
	}
	
	public void closeConnection() {
		try {
			if(rs !=null)
			rs.close();
			if(con !=null)
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("DB Connection has been closed!");
	}
	
	
	public int insertData(BeanCustomers Data ) {
		
		int result = 0;
		String sql= "insert into customers values(?,?,?,?,?)"; //方法中不能有private\public 等封装
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, Data.getID());
			ps.setString(2, Data.getName());
			ps.setInt(3, Data.getAge());
			ps.setDate(4, Data.getDOB());
			ps.setString(5, Data.getSex());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result <=0) {
			return -1;
		}
		
		return 0;
	}
	
	
	public BeanCustomers queryData( BeanCustomers Data) {
		
		String sql = "Select * from customers";
		
		//ArrayList al = new ArrayList<BeanCustomers>();
		
		if(Data.getID() >=0 ) sql = sql + " Where id="+  Data.getID() ;
		else if(Data.getName() != null) sql = sql + " Where Name='" + Data.getName()+"'";
		else if(Data.getAge() > 0) sql = sql + " Where Age=" + Data.getAge();
		else if(Data.getDOB() != null) sql = sql + " Where DOB='" + Data.getDOB().toString()+"'";
		else if(Data.getSex() != null) sql = sql + " Where Sex='" + Data.getSex()+"'";
		else {
			return ( new BeanCustomers(0, null, 0, null, null) );
		}
		
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				return (new BeanCustomers(
						rs.getInt("ID"), rs.getString("Name"), rs.getInt("Age"), 
						rs.getDate("DOB"), rs.getString("Sex")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (new BeanCustomers(0, null, 0, null, null));
		
	}
	

}
