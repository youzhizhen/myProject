package com.liying;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TestServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	    System.out.println("servlet init sart ......");
		System.out.println("servlet name:" + config.getServletName());
		System.out.println("servlet params:" + config.getInitParameterNames().toString());
		System.out.println("servlet context:" + config.getServletContext().getContextPath());
		System.out.println("servlet context:" + config.getInitParameter("username"));
		System.out.println("servlet init end ......");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.sendRedirect("index.jsp");
	    System.out.println("do post.......");
	}

}
