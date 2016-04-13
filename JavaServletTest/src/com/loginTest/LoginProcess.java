package com.loginTest;

import java.io.IOException;
import java.sql.*;
import java.text.Normalizer.Form;

import com.jdbcTest.SQLServerJDBCTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginProcess
 */
@WebServlet("/LoginProcess")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = req.getParameter("username"); //获取前一个servlet表单提交过来的参数
		String passwd = req.getParameter("passwd");
		HttpSession hs = req.getSession(true);//打开session空间
		hs.setMaxInactiveInterval(30);//设置session超时时间,以秒为单位
		hs.setAttribute("LoginCheck", null);//向session写入数据
		/*
		String jDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //数据库引擎
		String ConnectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=SQLServerTest"; //数据库连接串
		String User = "sa";
		String Pswd = "Jmh8906146";
		Connection con = null;
		*/
		SQLServerJDBCTest jdbc = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select top 1 passwd from users where name='" + user + "';";
		String dbpasswd = null;
		
		String errorInfo = java.net.URLEncoder.encode("The email ! @ # $& * ( ) = : / ; ? + 'or password you entered is incorrect.","utf-8");
		System.out.println("********************errorInfo =" + errorInfo);
		
		try {
			jdbc = new SQLServerJDBCTest();
			st = jdbc.con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				dbpasswd = rs.getString("passwd");
			}
			
			if(dbpasswd!=null && dbpasswd.equals(passwd)){
				System.out.println("验证成功!");
				hs.setAttribute("LoginCheck", "Pass");
				res.sendRedirect("welcome");
			}else{
				System.out.println("验证失败!!!");
				res.sendRedirect("login?info=" + errorInfo);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				rs.close();
				st.close();
				jdbc.con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		/*******
		if(user.equals("admin") && passwd.equals("admin")){
			res.sendRedirect("welcome?username=" + user + "&passwd=" + passwd); //跳转到另一个servlet
			hs.setAttribute("LoginCheck", "Pass");
		}else{
			//res.sendRedirect("login?username=" + user);
			res.sendRedirect("welcome?username=" + user + "&passwd=" + passwd); //跳转到另一个servlet
		}
		********/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
