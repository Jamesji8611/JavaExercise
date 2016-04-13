package com.servletTest;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest
 */
public class ServletHttpTest extends HttpServlet {

	//Get方法
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		//doGet中处理业务逻辑,doPost调用  或者doPost处理业务逻辑,doGet调用
		try{
			PrintWriter pw = res.getWriter();
			pw.println("Hello Wold! HttpServlet");
		} catch( Exception e){
			e.printStackTrace();
		}
	}
	//Post方法
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		this.doGet(req, res);
	}
}
