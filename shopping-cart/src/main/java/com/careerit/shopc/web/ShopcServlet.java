package com.careerit.shopc.web;

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

import com.careerit.shopc.domain.Item;
import com.careerit.shopc.service.ShopcServiceImpl;

@WebServlet("*.do")
public class ShopcServlet extends HttpServlet {
	
	private ShopcServiceImpl service = new ShopcServiceImpl();

	public ShopcServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		List<Item> items = service.getItems();
		req.setAttribute("items", items);
		String uri = req.getRequestURI();

		if (uri.endsWith("additemtocart.do")) {
			String itemName = req.getParameter("itemName");
			if (itemName != null) {
				Item item = service.getItemFromName(itemName);
				List<Item> itemList = new ArrayList<>();
				if (session.getAttribute("itemList") != null) {
					itemList = (List<Item>) session.getAttribute("itemList");
				}
				itemList.add(item);
				session.setAttribute("itemList", itemList);
			}
		}else if(uri.endsWith("removeitemfromcart.do")) {
			String itemName = req.getParameter("itemName");
			if (itemName != null) {
				List<Item> itemList = new ArrayList<>();
				if (session.getAttribute("itemList") != null) {
					itemList = (List<Item>) session.getAttribute("itemList");
					Item item = service.getItemFromName(itemName);
					itemList.remove(item);
				}
				session.setAttribute("itemList", itemList);
			}
		}else if(uri.endsWith("removeallitemfromcart.do")) {
			List<Item> itemList = new ArrayList<>();
			session.setAttribute("itemList", itemList);
		}else if(uri.endsWith("logout.do")) {
			if(session != null) {
				session.invalidate();
				resp.sendRedirect("*.do");
				return;
			}
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/items.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
