package com.myjavacode.jdbc;

import java.sql.Date;

public class JDBCTest {
	public static void main(String[] args) {
		
		DataOpernation dbo = new DataOpernation();
		
		
		BeanCustomers data = new BeanCustomers(0, null, 0, null, null);
		dbo.queryData(data).printData();
		
		data = new BeanCustomers(2, "Lynn", 18, Date.valueOf("1986-10-17"), "F");
		dbo.insertData(data);
		
		
		dbo.closeConnection();
	}
}
