package com.ServletMVC;
import java.sql.*;
import java.util.*;

public class UsersData {
	private String sql = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;
	private JDBCConnect jdbc = null;
	private long rowCount = 0;
	
	public long getRowCount() throws Exception {
		try{
			jdbc = new JDBCConnect();
			sql = "select count(*) from users";
			st = jdbc.Con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()){
				rowCount = rs.getInt(1);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			this.closeDB();
		}
		
		return rowCount;
	}
	
	//验证用户
	public boolean checkUser(String useName, String passwd) throws Exception{
		boolean checkResult = false;
		String dbPasswd = null;
		try{
			jdbc = new JDBCConnect();
			sql = "Select top 1 passwd from users where name ='" + useName + "'";
			st = jdbc.Con.prepareStatement(sql);
			rs = st.executeQuery();
			
			if(rs.next()){
				dbPasswd = rs.getString(1);
				if(dbPasswd.equals(passwd)){
					return true;
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			this.closeDB();
		}
		
		
		return checkResult;
	}
	//get Users List
	public ArrayList<UsersBean> userList(int pageSize, int pageNow) throws Exception{
		ArrayList<UsersBean> ar = new ArrayList<UsersBean>();
		UsersBean ub = new UsersBean();
		try{
			System.out.println("****pageSize=" + pageSize + " pageNow=" + pageNow);
			jdbc = new JDBCConnect();
			sql = "select top "+ pageSize +" * from users where id not in (select top "+ (pageSize*(pageNow -1)) +" id from users)";
			st = jdbc.Con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()){
				ub = new UsersBean();//ArrayList中存储的是object引用变量,因此必须每次都重新new一个实例,
				//否则新产生的数值相当于覆盖了同一个地址的上一个值!!!!!引用变量小心,就像指针一样!!!!
				ub.setUserID(rs.getInt(1));
				ub.setUserName(rs.getString(2));
				ub.setPassword(rs.getString(3));
				ub.setEmail(rs.getString(4));
				ub.setCustomLevel(rs.getString(5));
				
				ar.add(ub);
			}
			for(int i = 0; i < ar.size(); i++){
				UsersBean tmp = ar.get(i);
				System.out.println(tmp.getUserID()+" "+tmp.getUserName());
			}
			
		} catch( Exception e){
			e.printStackTrace();
		} finally{
			this.closeDB();
		}
		
		
		return ar;
	}
	
	private void closeDB() throws Exception{
		if(rs != null){
			rs.close();
			rs = null;
		}
		if(st != null){
			st.close();
			st = null;
		}
		if(jdbc.Con != null){
			jdbc.Con.close();
			jdbc.Con = null;
		}
	}
}
