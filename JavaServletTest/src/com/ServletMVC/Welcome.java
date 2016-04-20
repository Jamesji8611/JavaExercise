package com.ServletMVC;

import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;

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
@WebServlet("/WelcomeS")
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
		
		ArrayList<UsersBean> ar = null;
		UsersData ud = new UsersData();
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(int i = 0; i < cookies.length; i++){
				System.out.println("********Cookies:" + cookies[i].getName() + "= " + cookies[i].getValue());
			}
		}
		
		
		long rowCount = 0;
		try {
			rowCount = ud.getRowCount();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}//总记录数
		long pageCount=0;//计算后的总页数
		int rowsize = 10;//每页显示的记录数
		int pageNow = 1;//当前页码
		
		if(req.getParameter("pageNow") != null){
			pageNow = Integer.parseInt(req.getParameter("pageNow"));
		}
		
		try {
			ar = ud.userList(rowsize, pageNow);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(loginCheck != null && loginCheck.equals("Pass") ){
			pw.println("<image src=Images/001.gif width=150px length=150px><br><center>");
			pw.println("Welcome! <br><hr>");
			
			try{
				if(rowCount%rowsize == 0){
					pageCount = rowCount/rowsize;
				}else{
					pageCount = rowCount/rowsize + 1;
				}
				//System.out.println("rowCount = " + rowCount + " pageCount = " + pageCount);
				
				String ServletConTimes = this.getServletContext().getAttribute("VistTimes").toString();
				pw.println("<b>VisitTimes: "+ ServletConTimes +"</b><br>");
				pw.println("IP: " + req.getRemoteAddr()+ "<br>");
				pw.println("HostName: " + req.getRemoteHost()+ "<br>");
				pw.println("<table border=1>");
				pw.println("<tr><th>ID</th><th>Name</th><th>Passwd</th><th>Email</th><th>UserLevel</th></tr>");
				for(int i = 0; i < ar.size(); i++ ){
					//输出表
					pw.println("<tr>");
					pw.println("<td><a href=userdetails?userid="+ar.get(i).getUserID()+">"+ar.get(i).getUserID()+"</a></td>");
					pw.println("<td>"+ar.get(i).getUserName()+"</td>");
					pw.println("<td>"+ar.get(i).getPassword()+"</td>");
					pw.println("<td>"+ar.get(i).getEmail()+"</td>");
					pw.println("<td>"+ar.get(i).getCustomLevel()+"</td>");
					pw.println("</tr>");
				}
				pw.println("</table>");
				
				pw.println("<br><br>");
				if(pageNow != 1){
					pw.println("<a href=welcomeS?pageNow=" + (pageNow-1) + ">Last Page</a>");
					pw.println("<a href=welcomeS?pageNow=1><<1</a>");
				}
				for(int i = pageNow; (i <= (pageNow + 7)) && (i<=pageCount); i++ ){
					if(pageNow == i){
						pw.println("<a href=welcomeS?pageNow=" + i + "><b>" + i + "</b></a>");
					}else{
						pw.println("<a href=welcomeS?pageNow=" + i + ">" + i + "</a>");
					}
				}
				if(pageNow != pageCount){
					pw.println("<a href=welcomeS?pageNow="+pageCount+">>>"+pageCount+"</a>");
					pw.println("<a href=welcomeS?pageNow=" + (pageNow+1) + ">Next Page</a>");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			pw.println("</center>");
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
