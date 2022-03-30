package com.careertit.iplstat.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.careertit.iplstat.dto.TeamStatDto;
import com.careertit.iplstat.service.IplStatService;
import com.careertit.iplstat.service.IplStatServiceImpl;

/**
 * Servlet implementation class TeamStatServlet
 */
@WebServlet("/teamstat")
public class TeamStatServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private IplStatService iplStatService = new IplStatServiceImpl();

	public TeamStatServlet() {

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<TeamStatDto> list = iplStatService.getTeamStats();
		req.setAttribute("teamStatList", list);
		RequestDispatcher rd = req.getRequestDispatcher("/teamstat.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
