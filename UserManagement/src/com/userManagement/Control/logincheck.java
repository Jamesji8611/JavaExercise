package com.userManagement.Control;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import java.net.*;

import com.sun.net.httpserver.HttpContext;
import com.userManagement.Model.SystemManageBeanProcess;
import com.userManagement.Model.UsersBeanProcess;


/**
 * Servlet implementation class logincheck
 */
@WebServlet("/MVC/logincheck")
public class logincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincheck() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(){
    	System.out.println("The UsersManagement System is starting");
    	
    	int visittimes = 0;
    	SystemManageBeanProcess smbp = new SystemManageBeanProcess();
    	ServletContext sc = this.getServletContext(); 
    	try {
    		visittimes = smbp.startSystem();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			sc.setAttribute("LoginNum", visittimes+"");
			System.out.println("The UsersManagement System is working");
		}
    }
    
    public void destroy(){
    	System.out.println("The UsersManagement System is closing");
    	
    	int visittimes = 0;
    	SystemManageBeanProcess smbp = new SystemManageBeanProcess();
    	ServletContext sc = this.getServletContext();
    	
    	try{
    		visittimes = (sc.getAttribute("LoginNum")!=null)?(Integer.parseInt(sc.getAttribute("LoginNum").toString())):0;
    		smbp.closeSystem(visittimes);
    	} catch(Exception e){
    		e.printStackTrace();
    	} finally{
    		System.out.println("The UsersManagement System has closed");
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u = new String(req.getParameter("UserName").getBytes("ISO-8859-1"),"UTF-8"); //中文转码!!
		String p = req.getParameter("Passwd");
		HttpSession session = null;
		
		String inf = "Login Failed<br>Err username or passwd";
		inf = java.net.URLEncoder.encode(inf,"utf-8");
		System.out.println("ControlServlet: /MVC/logincheck");
		
		try{
			UsersBeanProcess ubp = new UsersBeanProcess();
			
			if(ubp.checkLogin(u, p)){
				System.out.println("Login Successful");
				session = req.getSession(true);
				session.setMaxInactiveInterval(12);
				session.setAttribute("UserName", u);
				session.setAttribute("Login", "Success");
				ServletContext sc = this.getServletContext();
				String s_LoginNum = (sc.getAttribute("LoginNum")!=null)?(sc.getAttribute("LoginNum").toString()):"0";
				long LoginNum = Integer.parseInt(s_LoginNum);
				
				LoginNum+=1;
				
				session.setAttribute("MyLoginNum", LoginNum+"");
				sc.setAttribute("LoginNum", LoginNum+"");

				//res.sendRedirect("Model1/Management.jsp"); //转向效率不高
				//一般软件公司使用此方法转发
				req.getRequestDispatcher("/View/Management.jsp").forward(req, res);
			}else{
				System.out.println("Login Failed");
				//res.sendRedirect(req.getContextPath()+"/Model1/Login.jsp?inf="+ inf);
				req.getRequestDispatcher("/View/Login.jsp?inf="+ inf).forward(req, res);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
	public static void checkTimeout(HttpServletRequest req, HttpServletResponse res){
		
		try {
			String Errinf = "<font color='red'>Time Out, Please login again!</font>";
			Errinf = URLEncoder.encode(Errinf, "UTF-8");
			if( (req.getSession().getAttribute("Login") ==null) || !req.getSession().getAttribute("Login").toString().equals("Success")){
				System.out.println("Time Out!");
				//res.sendRedirect("/View/Login.jsp?inf="+Errinf);
				req.getRequestDispatcher("/View/Login.jsp?inf="+Errinf).forward(req, res);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
