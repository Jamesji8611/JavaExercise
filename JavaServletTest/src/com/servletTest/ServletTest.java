/**
 * �ֶ�����һ��Servlet��Ŀ
 */
package com.servletTest;
import javax.servlet.*;

import java.io.*;

public class ServletTest implements Servlet {
	//����servletʵ��,�ͷ��ڴ�
	//1.reload ��servlet
	//2.�ر�Tomcat
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

	//�÷������ڳ�ʼ����Servlet(�����ڹ��췽��),�÷���ֻ�ᱻ����һ��
	//�÷���ֻ���û���һ�η���ʱ������
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Servlet Init");
		
	}
	//�÷������ڴ���ҵ���߼�
	//�÷�����ÿ���û�����ʱ���ᱻ����
	//ServletRequest req ���ڻ�ȡ�ͻ�����������, ServletResponse res ������ͻ��˷�����Ϣ
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet Service!");
		PrintWriter pw = res.getWriter();
		pw.println("Hello World!");
		
	}

}
