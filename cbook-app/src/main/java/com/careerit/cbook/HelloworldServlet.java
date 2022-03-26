package com.careerit.cbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloworld")
public class HelloworldServlet extends HttpServlet {

	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
			String name = req.getParameter("username");
			if(name == null) {
				name = "User";
			}
			req.setAttribute("user", name);
			//Logic
			List<String> list = new ArrayList<>();
			list.add("Krish");
			list.add("Manoj");
			list.add("Venkat");
			
			req.setAttribute("friends", list);
			
			//Logic
			RequestDispatcher rd = req.getRequestDispatcher("/greetings.jsp");
			rd.forward(req, resp);
		}
}
