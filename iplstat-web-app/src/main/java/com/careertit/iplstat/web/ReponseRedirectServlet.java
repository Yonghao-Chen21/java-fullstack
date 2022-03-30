package com.careertit.iplstat.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReponseRedirectServlet
 */
@WebServlet("/login")
public class ReponseRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("https://getbootstrap.com/docs/5.1/components/card?name=Krish&&mid=1323&&amout=30000");
		
//		StringBuffer url = request.getRequestURL();
//		String uri = request.getRequestURI();
//		String queryString = request.getQueryString();
//		System.out.println("URL :"+url);
//		System.out.println("URI :"+uri);
//		System.out.println("QStr:"+queryString);
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(userName+" "+password);
		// Validation 
		if(true) {
			
		}else{
			response.sendRedirect("login.jsp?message=Invalid user and password");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
