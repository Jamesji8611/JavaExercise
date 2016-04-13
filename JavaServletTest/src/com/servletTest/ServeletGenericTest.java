package com.servletTest;
import java.io.*;
import java.io.PrintWriter;

import javax.servlet.*;

public class ServeletGenericTest extends GenericServlet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse res){
		// TODO Auto-generated method stub
		try{
		PrintWriter pw = res.getWriter();
		pw.println("Hello World! Generic Servlet!");
		} catch( Exception e){
			e.printStackTrace();
		}
	}

}
