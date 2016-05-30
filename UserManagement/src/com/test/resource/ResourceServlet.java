package com.test.resource;

import java.io.IOException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResourceServlet
 */
@WebServlet("/ResourceServlet")
public class ResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private @Resource(name="resource") String resource;
    /**
     * @see HttpServlet#HttpServlet()
     */
	//private @Resource(name="resource") String resource;
	
    public ResourceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("*******@Resource=" + resource);
//		try{
//			Context ctx = new InitialContext();
//			String resource = ctx.lookup("resource")!=null?((String)ctx.lookup("resource")):"null";
//			System.out.println("resource=" + resource);
//		} catch(Exception e){
//			e.printStackTrace();
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
