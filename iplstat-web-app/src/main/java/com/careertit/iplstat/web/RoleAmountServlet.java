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

import com.careertit.iplstat.dto.RoleAmountDTO;
import com.careertit.iplstat.service.IplStatService;
import com.careertit.iplstat.service.IplStatServiceImpl;

@WebServlet("/roleamount")
public class RoleAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IplStatService iplStatService = new IplStatServiceImpl();

	public RoleAmountServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		List<String> teamCodes = iplStatService.getTeamNames();
		teamCodes.add("ALL");
		String teamCode = req.getParameter("teamCode");
		List<RoleAmountDTO> rlist = new ArrayList<RoleAmountDTO>();
		if (teamCode != null && !teamCode.isEmpty())
			rlist.addAll(iplStatService.getRoleAmount(teamCode.trim()));
		req.setAttribute("teamCodes", teamCodes);
		req.setAttribute("rlist", rlist);
		req.setAttribute("teamName", teamCode);
		RequestDispatcher rd = req.getRequestDispatcher("/roleamount.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}