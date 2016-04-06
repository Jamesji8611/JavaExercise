/**
 * JDBC-SQL执行
 */
package com.jdbcTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExcuteSQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQLServerJDBCTest jdbc1 = new SQLServerJDBCTest();
		
		String sql = "select * from test1";
		Statement st = null;
		try {
			st = jdbc1.con.createStatement(); //创建sql执行对象
			ResultSet rs = st.executeQuery(sql); //执行sql语句,并将结果集返回
			while(rs.next()){
				System.out.println(rs.getString("ID") + "\t" + rs.getString("Name") + "\t" 
								+ rs.getString("Age") + "\t" + rs.getString("Country") );
			}
			
			st.close();
			jdbc1.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
