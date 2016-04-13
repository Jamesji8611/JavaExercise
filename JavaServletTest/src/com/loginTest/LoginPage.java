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
		res.setContentType("text/html; charset=utf-8"); //设置编码传输格式,防止中文乱码
		PrintWriter pw = res.getWriter();
		//pw.println("<html type='text/html' charset='gbk'>");
		pw.println("<html>");
		pw.println("<Body>");
		if(req.getParameter("info") != null){
			pw.println("<h1>"+ java.net.URLDecoder.decode( req.getParameter("info"), "utf-8") + "</h1>");
		}
		
		pw.println("<form action=loginProcess method=post>"); //action 为表单form提交时的下一个servlet,此处填写servlet-url
		pw.println("<h1>登录</h1>");
		pw.println("用户名: <input text='用户名' type=text name='username'/><br>");
		pw.println("密	码:<input text='密    码' type=password name='passwd'/><br>");
		pw.println("<input text='登    录' type=submit name='submit'/><br>");
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
