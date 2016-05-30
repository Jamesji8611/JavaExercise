package com.userManagement.Control;

import java.io.IOException;
import java.util.ArrayList;
import java.net.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userManagement.Model.UsersBean;
import com.userManagement.Model.UsersBeanProcess;

/**
 * Servlet implementation class UsersData
 */
@WebServlet("/MVC/UsersData")
public class UsersData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logincheck.checkTimeout(request, response);
		
		UsersBeanProcess ubp = new UsersBeanProcess();
		String flag = request.getParameter("OpFlag");
		int pageNow = request.getParameter("pageNow")!=null?Integer.parseInt(request.getParameter("pageNow")):0;
		UsersBean ub = null;
		String inf = "";
		
		System.out.println("ControlServlet: /MVC/UsersData OpFlag="+ flag);
		
		if(flag.equals("allusers")){//显示所有用户
			int pageCount = ubp.getPageCount();
			ArrayList<UsersBean> al = new ArrayList<UsersBean>();
			al = ubp.showUsers(pageNow);
			
			request.setAttribute("UsersData", al);
			request.setAttribute("pageCount", pageCount);
			
			request.getRequestDispatcher("/View/ManagementUsers.jsp").forward(request, response);			
		}else if(flag.equals("adduser")){//添加用户
			String username= new String(request.getParameter("username").toString().getBytes("ISO-8859-1"),"UTF-8");
			String passwd = request.getParameter("passwd").toString();
			String email = request.getParameter("email").toString();
			int customlevel = Integer.parseInt(request.getParameter("customlevel").toString());
			
			if(ubp.addUser(username, passwd, email, customlevel)){
				request.getRequestDispatcher("/MVC/UsersData?OpFlag=allusers&pageNow=" + (ubp.getPageCount()-1)).forward(request, response);
			}else{
				inf = URLEncoder.encode("Failed!!!","utf-8");
				request.getRequestDispatcher("/View/Error.jsp?inf="+inf).forward(request, response);
			}
			
		}else if(flag.equals("upuser")){//修改用户
			
			try{
				
				int id = Integer.parseInt(request.getParameter("ID").toString());
				String passwd = request.getParameter("Passwd").toString();
				String email = request.getParameter("Email").toString();
				int userlevel = Integer.parseInt(request.getParameter("customLevel").toString());
				
				if(ubp.upUser(id, passwd, email, userlevel)){
					inf = URLEncoder.encode("update succeed!", "utf-8");
					request.getRequestDispatcher("/MVC/UsersData?OpFlag=queryuser&ID=" + id + "&pageNow="+pageNow+"&inf="+inf).forward(request, response);
				}else{
					inf = URLEncoder.encode("Failed!!!","utf-8");
					request.getRequestDispatcher("/View/Error.jsp?inf="+inf).forward(request, response);
				}
			} catch(Exception e){
				e.printStackTrace();
			}
			
			
		}else if(flag.equals("deluser")){//删除用户
			try{
				int id = Integer.parseInt(request.getParameter("id"));
				if(ubp.delUser(id)){
					request.getRequestDispatcher("/MVC/UsersData?OpFlag=allusers&pageNow=" + pageNow).forward(request, response) ;
				}else{
					inf = URLEncoder.encode("Failed!!!","utf-8");
					request.getRequestDispatcher("/View/Error.jsp?inf="+inf).forward(request, response);
				}
			} catch(Exception e){
				e.printStackTrace();
			}			
			
		}else if(flag.equals("queryuser")){//查找单个用户的信息
			String id = request.getParameter("ID");
			ub = ubp.queryUser(Integer.parseInt(id));
			request.setAttribute("UsersBean", ub);
			request.getRequestDispatcher("/View/UpdateUsers.jsp").forward(request, response);
			
		}else if(flag.equals("queryusers")){//查找多个用户的信息
			
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
