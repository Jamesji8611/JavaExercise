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
		String user = req.getParameter("username"); //��ȡǰһ��servlet���ύ�����Ĳ���
		String passwd = req.getParameter("passwd");
		HttpSession hs = req.getSession(true);//��session�ռ�
		hs.setMaxInactiveInterval(30);//����session��ʱʱ��,����Ϊ��λ
		hs.setAttribute("LoginCheck", null);//��sessionд������
		/*
		String jDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //���ݿ�����
		String ConnectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=SQLServerTest"; //���ݿ����Ӵ�
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
				System.out.println("��֤�ɹ�!");
				hs.setAttribute("LoginCheck", "Pass");
				res.sendRedirect("welcome");
			}else{
				System.out.println("��֤ʧ��!!!");
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
			res.sendRedirect("welcome?username=" + user + "&passwd=" + passwd); //��ת����һ��servlet
			hs.setAttribute("LoginCheck", "Pass");
		}else{
			//res.sendRedirect("login?username=" + user);
			res.sendRedirect("welcome?username=" + user + "&passwd=" + passwd); //��ת����һ��servlet
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
