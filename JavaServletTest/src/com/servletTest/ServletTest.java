/**
 * 手动创建一个Servlet项目
 */
package com.servletTest;
import javax.servlet.*;

import java.io.*;

public class ServletTest implements Servlet {
	//销毁servlet实例,释放内存
	//1.reload 该servlet
	//2.关闭Tomcat
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Servlet Destory!");
	}	

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	//该方法用于初始化该Servlet(类似于构造方法),该方法只会被调用一次
	//该方法只在用户第一次访问时被调用
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Servlet Init");
		
	}
	//该方法用于处理业务逻辑
	//该方法在每次用户访问时都会被调用
	//ServletRequest req 用于获取客户端输入请求, ServletResponse res 用于向客户端返回信息
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet Service!");
		PrintWriter pw = res.getWriter();
		pw.println("Hello World!");
		
	}

}
