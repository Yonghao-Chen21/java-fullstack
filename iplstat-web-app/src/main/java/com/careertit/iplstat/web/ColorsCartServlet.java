package com.careertit.iplstat.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.do")
public class ColorsCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String uri = req.getRequestURI();

		if (uri.endsWith("addcolortocart.do")) {
			String color = req.getParameter("color");

			if (color != null) {
				List<String> sclors = new ArrayList<>();
				if (session.getAttribute("colorList") != null) {
					sclors = (List<String>) session.getAttribute("colorList");
				}
				sclors.add(color);
				session.setAttribute("colorList", sclors);
			}
		}else if(uri.endsWith("removeitemfromcart.do")) {
			String color = req.getParameter("color");

			if (color != null) {
				List<String> scolors = new ArrayList<>();
				if (session.getAttribute("colorList") != null) {
					scolors = (List<String>) session.getAttribute("colorList");
					scolors.remove(color);
				}
				session.setAttribute("colorList", scolors);
			}
		}else if(uri.endsWith("removeallitemfromcart.do")) {
			List<String> sclors = new ArrayList<>();
			session.setAttribute("colorList", sclors);
		}else if(uri.endsWith("logout.do")) {
			if(session != null) {
				session.invalidate();
				resp.sendRedirect("colors.jsp");
				return;
			}
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/colors.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
