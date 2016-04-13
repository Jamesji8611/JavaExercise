package com.loginTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		res.setContentType("text/html; charset=utf-8"); //���ñ��봫���ʽ,��ֹ��������
		PrintWriter pw = res.getWriter();
		//pw.println("<html type='text/html' charset='gbk'>");
		pw.println("<html>");
		pw.println("<Body>");
		if(req.getParameter("info") != null){
			pw.println("<h1>"+ java.net.URLDecoder.decode( req.getParameter("info"), "utf-8") + "</h1>");
		}
		
		pw.println("<form action=loginProcess method=post>"); //action Ϊ��form�ύʱ����һ��servlet,�˴���дservlet-url
		pw.println("<h1>��¼</h1>");
		pw.println("�û���: <input text='�û���' type=text name='username'/><br>");
		pw.println("��	��:<input text='��    ��' type=password name='passwd'/><br>");
		pw.println("<input text='��    ¼' type=submit name='submit'/><br>");
		pw.println("</form>");
		pw.println("</Body>");
		pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, res);
	}

}
