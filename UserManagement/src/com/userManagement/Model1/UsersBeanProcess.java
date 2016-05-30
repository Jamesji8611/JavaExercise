package com.userManagement.Model1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.userManagement.JDBCConnect.JDBCConnect;

public class UsersBeanProcess {
	
	private JDBCConnect jdbc = null;
	private String sql = "";
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private int Rowspage=10; //页面显示条数
	public int getRowspage(){
		return Rowspage;
	}
	private int Nowpage =0; //当前页面
	private int PageCount =0; //总页数
	private int RowsCount =0; //总记录数
	
	private void closeDC(){ //close DatabaseConnection
		try{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(jdbc.Con !=null) jdbc.Con.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean checkLogin(String username, String passwd){
		boolean b = false;
		try{
			sql = "select top 1 u.passwd from users u where u.name = '"+ username +"'";
			jdbc = new JDBCConnect();
			ps = jdbc.Con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()){
				if(passwd.equals(rs.getString(1))){
					b = true;
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			this.closeDC();
		}
		
		return b;
	}
	
	public int getRowsCount(){
		try{
			sql="select count(*) from users";
			jdbc = new JDBCConnect();
			ps = jdbc.Con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			this.closeDC();
		}
		
		return 0;
	}
	
	public int getPageCount(){
		RowsCount = this.getRowsCount();
		if(RowsCount%Rowspage == 0){
			PageCount = RowsCount/Rowspage;
		}else{
			PageCount = RowsCount/Rowspage + 1;
		}
		
		return PageCount;
	}
	
	public ArrayList<UsersBean> showUsers( int PageNow){
		ArrayList<UsersBean> al = new ArrayList<UsersBean>();
		UsersBean ub = null;
		
		try{	
			sql="select top "+ Rowspage +" * from users u where u.id not in(select top "+ (Rowspage*PageNow) +" id from users)";
			jdbc = new JDBCConnect();
			ps = jdbc.Con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				ub = new UsersBean();
				ub.setId(rs.getInt(1));
				ub.setName(rs.getString(2));
				ub.setPasswd(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setUserlevel(rs.getInt(5));
				
				al.add(ub);
			}			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			this.closeDC();
		}
		
		return al;
	}
	
	public UsersBean queryUser(int id){
		UsersBean ub = new UsersBean();
		try{
			sql="select top 1 * from users where id=" + id;
			jdbc = new JDBCConnect();
			ps = jdbc.Con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				ub.setId(rs.getInt(1));
				ub.setName(rs.getString(2));
				ub.setPasswd(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setUserlevel(rs.getInt(5));
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			this.closeDC();
		}
		
		return ub;
	}

}
