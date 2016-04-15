package com.ServletMVC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginProcess
 */
@WebServlet("/LoginProcessS")
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
		
		UsersData ud = null;
		
		String saveCookie = req.getParameter("savecookies");
		
		//Session
		HttpSession hs = req.getSession(true);//��session�ռ�
		hs.setMaxInactiveInterval(300);//����session��ʱʱ��,����Ϊ��λ
		hs.setAttribute("LoginCheck", null);//��sessionд������
		
		//Cookies
		Cookie myCookie = null;
		//Cookie[] cookies = null;
		
		
		String errorInfo = java.net.URLEncoder.encode("The email ! @ # $& * ( ) = : / ; ? + 'or password you entered is incorrect.","utf-8");
		System.out.println("********************errorInfo =" + errorInfo);
		
		try {
			ud = new UsersData();
			if( ud.checkUser(user, passwd) ){
				System.out.println("��֤�ɹ�!");
				hs.setAttribute("LoginCheck", "Pass");
				
				if(saveCookie != null){
					myCookie = new Cookie("userName", user);
					myCookie.setMaxAge(30);//����Cookie��Чʱ��, in seconds
					res.addCookie(myCookie);
					myCookie = new Cookie("passwd", passwd);
					res.addCookie(myCookie);
				}
				
				res.sendRedirect("welcomeS");
				
			}else{
				System.out.println("��֤ʧ��!!!");
				res.sendRedirect("loginS?info=" + errorInfo);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
