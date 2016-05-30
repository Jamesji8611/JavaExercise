package com.userManagement.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;

import com.userManagement.JDBCConnect.JDBCConnect;

public class SystemManageBeanProcess {
	
	JDBCConnect jdbc = null;
	String sql = "";
	PreparedStatement ps = null;
	ResultSet rs = null;
	SystemManageBean smb = null;
	
	public int startSystem() throws Exception{
		
		try{
			jdbc = new JDBCConnect();
			smb = new SystemManageBean();
			sql ="select top 1 * from systemmanage order by startdate desc";
			ps = jdbc.Con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()){
				smb.setStartdate(rs.getString(1));
				smb.setEnddate(rs.getString(2));
				smb.setVisittimes(rs.getInt(3));
				smb.setAvilable(rs.getInt(4));
			}
			
			sql = "insert into systemmanage values (getdate(), null, "+ smb.getVisittimes() +", 1)";
			ps = jdbc.Con.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			this.closeDB();
		}
		
		return smb.getVisittimes();
	}
	
	public void closeSystem(int visittimes) throws Exception{
		
		try{
			jdbc = new JDBCConnect();
			smb = new SystemManageBean();
			sql = "update t set t.enddate=getdate(), t.avilable=0, t.visittimes="+ visittimes +"  from (select top 1 * from SystemManage order by startdate desc) t";
			ps = jdbc.Con.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			this.closeDB();
		}		
		
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
