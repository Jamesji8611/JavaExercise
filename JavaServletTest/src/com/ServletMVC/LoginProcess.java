package com.ServletMVC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
    
    private String file = "D:/ProgramFile/apache-tomcat-7.0.68/webapps/HelloWorld/Files/Web.txt";
    //override init()
    public void init(){
    	System.out.println("********init()");
    	//Open File & write ServletContext
		BufferedReader br = null;
		FileReader fr = null;
		String readLine = null;
		ManagementData md = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			readLine = br.readLine(); //ע��readLine��ʹ��,ÿִ��һ�ξ����¶�һ��,�����ڴ˴�ֻ�ܱ�����һ��!!!
			String fileTimes = (readLine==null)?"0":(readLine);
			md = new ManagementData();
			String dataTimes = md.managestart();
			System.out.println("fileTimes =" + fileTimes + " dataTimes =" + dataTimes);
			this.getServletContext().setAttribute("VistTimes", fileTimes);
			//System.out.println("br.readLine()= " + fileTimes + " ServletContext= " + this.getServletContext().getAttribute("VistTimes"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    
    //Override destroy()
    public void destroy(){
    	BufferedWriter bw = null;
    	FileWriter fw = null;
    	ManagementData md = null;
    	//get servletContext and write to file
    	try{
    		fw = new FileWriter(file);
    		bw = new BufferedWriter(fw);
    		String VistTimes = this.getServletContext().getAttribute("VistTimes").toString();
    		System.out.println("***********" + VistTimes);
    		VistTimes = ((VistTimes==null)?"0":VistTimes);
    		bw.write(VistTimes);
    		md = new ManagementData();
    		md.manageclose( Integer.parseInt(VistTimes) );
    	} catch(Exception e){
    		e.printStackTrace();
    	} finally{
    		try{
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
				
				//write servletContext
				System.out.println(this.getServletContext().getAttribute("VistTimes"));
				String ServletConTimes = this.getServletContext().getAttribute("VistTimes").toString();
				//System.out.println(Integer.getInteger(ServletConTimes)+1);
				this.getServletContext().setAttribute("VistTimes", (((Integer.parseInt(ServletConTimes))+1)+""));
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
