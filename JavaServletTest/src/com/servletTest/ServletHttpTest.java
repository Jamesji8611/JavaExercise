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

	//Get����
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		//doGet�д���ҵ���߼�,doPost����  ����doPost����ҵ���߼�,doGet����
		try{
			PrintWriter pw = res.getWriter();
			pw.println("Hello Wold! HttpServlet");
		} catch( Exception e){
			e.printStackTrace();
		}
	}
	//Post����
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		this.doGet(req, res);
	}
}
