package com.careerit.cbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.careerit.ipl.CsvReaderUtil;
import com.careerit.ipl.Player;

@WebServlet("/ipl")
public class IplStatServlet extends HttpServlet {
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
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Hello World!</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<form action='ipl'>");
		sb.append("<select name='teamName'>");	
		for(String teamName:teamNames) {
			sb.append("<option value='"+teamName+"'>"+teamName+"</option>");
		}
		sb.append("</select>");
		sb.append("<input type='submit' value='Submit'>");
		sb.append("</form>");
		
		String teamName = req.getParameter("teamName");
		
		if(teamName!=null && !teamName.isEmpty()) {
			sb.append("<hr>");
			List<Player> plist = teamPlayerMap.get(teamName.trim());
			sb.append("<table border='1' width='50%'>");
			sb.append("<thead><tr><th>Name</th><th>Role</th><th>Price</th><th>Country</th><th>Team</th></tr></thead>");
			sb.append("<tbody>");
			for(Player p:plist) {
				sb.append("<tr>");
				sb.append("<td>"+p.getName()+"</td>");
				sb.append("<td>"+p.getRole()+"</td>");
				sb.append("<td>"+p.getPrice()+"</td>");
				sb.append("<td>"+p.getCountry()+"</td>");
				sb.append("<td>"+p.getTeam()+"</td>");
				sb.append("</tr>");
			}
			sb.append("</tbody>");
			sb.append("</table>");
		}else {
			sb.append("<p>Select team to see the player details</p>");
		}
		
		sb.append("</body>");
		sb.append("</html>");
		
		
		
		PrintWriter out = resp.getWriter();
		out.print(sb.toString());

	}
}
