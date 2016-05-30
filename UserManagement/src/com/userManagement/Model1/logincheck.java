package com.userManagement.Model1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class logincheck
 */
@WebServlet("/logincheck")
public class logincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u = req.getParameter("UserName");
		String p = req.getParameter("Passwd");
		HttpSession session = null;
		
		String inf = "Login Failed<br>Err username or passwd";
		inf = java.net.URLEncoder.encode(inf,"utf-8");		
		
		try{
			UsersBeanProcess ubp = new UsersBeanProcess();
			
			if(ubp.checkLogin(u, p)){
				System.out.println("Login Successful");
				session = req.getSession(true);
				session.setMaxInactiveInterval(1200);
				session.setAttribute("UserName", u);
				//res.sendRedirect("Model1/Management.jsp"); //转向效率不高
				//一般软件公司使用此方法转发
				req.getRequestDispatcher("Model1/Management.jsp").forward(req, res);
			}else{
				System.out.println("Login Failed");
				//res.sendRedirect(req.getContextPath()+"/Model1/Login.jsp?inf="+ inf);
				req.getRequestDispatcher(req.getContextPath()+"/Model1/Login.jsp?inf="+ inf).forward(req, res);
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

}
