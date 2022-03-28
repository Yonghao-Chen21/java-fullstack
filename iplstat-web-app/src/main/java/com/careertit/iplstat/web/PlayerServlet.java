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

import com.careertit.iplstat.domain.Player;
import com.careertit.iplstat.service.IplStatService;
import com.careertit.iplstat.service.IplStatServiceImpl;

@WebServlet("/player")
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IplStatService iplStatService = new IplStatServiceImpl();

	public PlayerServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		List<String> teamCodes = iplStatService.getTeamNames();
		String teamCode = req.getParameter("teamCode");
		List<Player> plist = new ArrayList<Player>();
		if (teamCode != null && !teamCode.isEmpty())
			plist.addAll(iplStatService.getPlayers(teamCode.trim()));
		req.setAttribute("teamCodes", teamCodes);
		req.setAttribute("plist", plist);
		RequestDispatcher rd = req.getRequestDispatcher("/player.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
