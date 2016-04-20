package com.ServletMVC;

import java.sql.*;
import java.text.SimpleDateFormat;

public class ManagementData {
	
	private ManagementBean mb = null;
	private String sql = "";
	JDBCConnect jdbc = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public String managestart() throws Exception{
		String visitTimes = "";
		mb = new ManagementBean();
		sql = "select top 1 * from Management order by Startdate desc";
		jdbc = new JDBCConnect();
		ps = jdbc.Con.prepareStatement(sql);
		rs = ps.executeQuery();
		if(rs.next()){
			mb.setStartdate(rs.getDate(1).toString());
			mb.setEnddate(rs.getDate(2).toString());
			mb.setVisittimes(rs.getInt(3));
		}else{
			mb.setStartdate( new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").toString());
			mb.setEnddate(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").toString());
			mb.setVisittimes(0);
		}
		
		sql = "insert into Management values( getdate(), getdate(), " + mb.getVisittimes() + ", 1)";
		visitTimes = Integer.toString(mb.getVisittimes());
		ps = jdbc.Con.prepareStatement(sql);
		ps.executeUpdate();
		
		this.closeDB();
		
		return visitTimes;
	}
	
	public void manageclose(int visitTimes) throws Exception{
		sql = "update t set t.avilable= 0, t.Enddate = getdate(), t.visittimes = "+ visitTimes +" from (select top 1 * from Management m order by m.Startdate desc) t";
		jdbc = new JDBCConnect();
		ps = jdbc.Con.prepareStatement(sql);
		ps.executeUpdate();
		
		this.closeDB();
	}
	
	private void closeDB() throws Exception{
		if(rs != null){
			rs.close();
			rs = null;
		}
		if(ps != null){
			ps.close();
			ps = null;
		}
		if(jdbc.Con != null){
			jdbc.Con.close();
			jdbc.Con = null;
		}
	}
}
