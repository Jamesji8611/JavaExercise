package com.loginTest;

import java.io.IOException;

import com.jdbcTest.*;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs = req.getSession(true);//打开session空间
		String loginCheck = (String)hs.getAttribute("LoginCheck");
		
		res.setContentType("text/html; charset=gbk");
		PrintWriter pw = res.getWriter();
		SQLServerJDBCTest jdbc = null;
		Connection co = null;
		PreparedStatement ps = null; //欲执行
		Statement st = null;//执行
		String sql = null;
		ResultSet rs = null;
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(int i = 0; i < cookies.length; i++){
				System.out.println("********Cookies:" + cookies[i].getName() + "= " + cookies[i].getValue());
			}
		}
		
		
		int rowCount=0;//总记录数
		int pageCount=0;//计算后的总页数
		int rowsize = 10;//每页显示的记录数
		int pageNow = 1;//当前页码
		
		if(req.getParameter("pageNow") != null){
			pageNow = Integer.parseInt(req.getParameter("pageNow"));
		}
		
		if(loginCheck != null && loginCheck.equals("Pass") ){
			pw.println("<image src=Images/001.gif width=150px length=150px><br>");
			pw.println("Welcome! <br>");
			
			try{
				jdbc = new SQLServerJDBCTest();
				st = jdbc.con.createStatement();
				sql = "select count(*) from users;";
				rs = st.executeQuery(sql);
				
				if(rs.next()){
					rowCount = rs.getInt(1);
					if(rowCount%rowsize == 0){
						pageCount = rowCount/rowsize;
					}else{
						pageCount = rowCount/rowsize + 1;
					}
					//System.out.println("rowCount = " + rowCount + " pageCount = " + pageCount);
				}
				sql = "select top "+rowsize+" * from users where id not in (select top "+rowsize*(pageNow - 1)+" id from users)";
				ps = jdbc.con.prepareStatement(sql);
				//ps.setInt(1, rowsize);//传递参数
				//ps.setInt(2, rowsize*(pageNow - 1));
				rs = ps.executeQuery();
				pw.println("<table border=1>");
				pw.println("<tr><th>ID</th><th>Name</th><th>Passwd</th><th>Email</th><th>UserLevel</th></tr>");
				while(rs.next()){
					//输出表
					pw.println("<tr>");
					pw.println("<td>"+rs.getInt(1)+"</td>");
					pw.println("<td>"+rs.getString(2)+"</td>");
					pw.println("<td>"+rs.getString(3)+"</td>");
					pw.println("<td>"+rs.getString(4)+"</td>");
					pw.println("<td>"+rs.getInt(5)+"</td>");
					pw.println("</tr>");
				}
				pw.println("</table>");
				
				pw.println("<br><br>");
				if(pageNow != 1){
					pw.println("<a href=welcome?pageNow=" + (pageNow-1) + ">Last Page</a>");
					pw.println("<a href=welcome?pageNow=1><<1</a>");
				}
				for(int i = pageNow; (i <= (pageNow + 7)) && (i<=pageCount); i++ ){
					if(pageNow == i){
						pw.println("<a href=welcome?pageNow=" + i + "><b>" + i + "</b></a>");
					}else{
						pw.println("<a href=welcome?pageNow=" + i + ">" + i + "</a>");
					}
				}
				if(pageNow != pageCount){
					pw.println("<a href=welcome?pageNow="+pageCount+">>>"+pageCount+"</a>");
					pw.println("<a href=welcome?pageNow=" + (pageNow+1) + ">Next Page</a>");
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(rs != null){
						rs.close();
					}
					if(ps != null){
						ps.close();
					}
					if(st != null){
						st.close();
					}
					if(jdbc.con != null){
						jdbc.con.close();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}else{
			pw.println("非法登录!");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
