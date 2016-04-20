package com.ServletMVC;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpRetryException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUsers extends HttpServlet{
	PrintWriter pw = null;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html; charset=utf-8");
		pw = res.getWriter();
		
		pw.println("<html>");
		pw.println("<Body bgcolor=1291F1>");
		pw.println("<img src =Images/003.gif width=117px length=175px><hr><center>");
		pw.println("<b>Update Users</b>");
		
		String userId = req.getParameter("userid").toString();
		UsersData ud = new UsersData();
		UsersBean ub = new UsersBean();

		try {
			ub = ud.queryUsers(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(ub.getUserID() + " " + ub.getUserName());
		pw.println("<form action=? method=post>");
		pw.println("<tr><td>UserID:<input type=text name=UserID readonly=true value="+ub.getUserID()+"></td><br></tr>");
		pw.println("<tr><td>UserName:<input type=text name=UserName value="+ub.getUserName()+"></td><br></tr>");
		pw.println("<tr><td>Passwd:<input type=passwd name=Passwd value="+ub.getPassword()+"></td><br></tr>");
		pw.println("<tr><td>Email:<input type=text name=Email value="+ub.getEmail()+"></td><br></tr>");
		pw.println("<tr><td>CustomerLevel:<input type=text name=CustomerLevel value="+ub.getCustomLevel()+"></input></td><br></tr>");
		pw.println("<hr><br><hr>");
		pw.println("<input text=Update type=submit name='submit'>");
		pw.println("</tr></form>");
		pw.println("</center></body></html>");
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		this.doGet(req, res);
	}
	
}
