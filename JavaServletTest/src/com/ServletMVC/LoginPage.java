package com.ServletMVC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPageS")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String file = "D:/ProgramFile/apache-tomcat-7.0.68/webapps/HelloWorld/Files/Web.txt";
    //override init()
    public void init11(){
    	System.out.println("********init()");
    	//Open File & write ServletContext
		BufferedReader br = null;
		FileReader fr = null;
		String fileTimes = "0";
		String brRead = "";
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			brRead = br.readLine();
			System.out.println("***********1**************");
			//fileTimes = ( (br.readLine()==null)?"0":(br.readLine()) );
			if(brRead == null){
				System.out.println("br.readLine() == null");
				fileTimes = "0";
			}else{
				System.out.println("br.readLine() != null" + brRead);
				fileTimes = brRead;
			}
			this.getServletContext().setAttribute("VistTimes", fileTimes);
			System.out.println("br.readLine()= " + fileTimes + " ServletContext= " + this.getServletContext().getAttribute("VistTimes"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//br.close();
				//fr.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    
    //Override destroy()
    public void destroy11(){
    	BufferedWriter bw = null;
    	FileWriter fw = null;
    	String VistTimes = "";
    	String ConnectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=SQLServerTest";
    	//get servletContext and write to file
    	try{
    		VistTimes = ((this.getServletContext().getAttribute("VistTimes")==null)?"0":(this.getServletContext().getAttribute("VistTimes").toString()));
    		System.out.println("***********VistTimes = " + VistTimes);
    		
    		fw = new FileWriter(file);
    		bw = new BufferedWriter(fw);
    		
    		VistTimes = ((VistTimes==null)?"0":VistTimes);
    		bw.write(this.getServletContext().getAttribute("VistTimes").toString());
    	} catch(Exception e){
    		e.printStackTrace();
    	} finally{
    		try{
    			DriverManager.deregisterDriver(DriverManager.getDriver(ConnectDB));
    			bw.close();
        		fw.close();
    		} catch(Exception e){
    			e.printStackTrace();
    		}
    		
    	}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String username = req.getParameter("username");
		res.setContentType("text/html; charset=utf-8"); //设置编码传输格式,防止中文乱码
		PrintWriter pw = res.getWriter();
		//pw.println("<html type='text/html' charset='gbk'>");
		pw.println("<html>");
		pw.println("<Body>");  //bgcolor=1291F1
		pw.println("<img src =Images/003.gif width=117px length=175px><hr><center>");
		if(req.getParameter("info") != null){
			pw.println("<h1>"+ java.net.URLDecoder.decode( req.getParameter("info"), "utf-8") + "</h1>");
		}//URL中不允许例如空格\%\+等特殊字符,需在此处进行格式化
		
		pw.println("<form action=loginProcessS method=post>"); //action 为表单form提交时的下一个servlet,此处填写servlet-url
		pw.println("<h1>登录</h1>");
		pw.println("用户名: <input text='用户名' type=text name='username'/><br>");
		pw.println("密	码:<input text='密    码' type=password name='passwd'/><br>");
		pw.println("<input type= checkbox name=savecookies value=2>是否保留cookie<br>");
		pw.println("<input text='登    录' type=submit name='submit'/><br>");
		pw.println("</center><hr><img src =>");
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
