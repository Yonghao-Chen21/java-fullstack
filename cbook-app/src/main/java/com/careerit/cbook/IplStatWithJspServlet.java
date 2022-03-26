package com.careerit.cbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.careerit.ipl.CsvReaderUtil;
import com.careerit.ipl.Player;

@WebServlet("/iplstat")
public class IplStatWithJspServlet extends HttpServlet {
	private List<String> teamNames = new ArrayList<String>();
	private List<Player> players;
	private Map<String,List<Player>> teamPlayerMap;

	@Override
	public void init() throws ServletException {
		players = CsvReaderUtil.obj.loadPlayers();
		teamNames.addAll(players.stream().map(p -> p.getTeam()).collect(Collectors.toSet()));
		teamPlayerMap = players.stream().collect(Collectors.groupingBy(Player::getTeam));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		String teamName = req.getParameter("teamName");
		List<Player> plist =new ArrayList<Player>();
		if(teamName!=null && !teamName.isEmpty())
			plist.addAll(teamPlayerMap.get(teamName.trim()));
		req.setAttribute("teamNames", teamNames);
		req.setAttribute("plist", plist);
		RequestDispatcher rd = req.getRequestDispatcher("/iplstat.jsp");
		rd.forward(req, resp);
		
		

	}
}
