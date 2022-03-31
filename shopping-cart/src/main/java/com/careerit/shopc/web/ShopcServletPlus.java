package com.careerit.shopc.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.careerit.shopc.domain.Item;
import com.careerit.shopc.service.ShopcServiceImpl;

@WebServlet("*.do2")
public class ShopcServletPlus extends HttpServlet {
	
	private ShopcServiceImpl service = new ShopcServiceImpl();

	public ShopcServletPlus() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		List<Item> items = service.getItems();
		req.setAttribute("items", items);
		String uri = req.getRequestURI();

		if (uri.endsWith("additemtocart.do2")) {
			String itemName = req.getParameter("itemName");
			if (itemName != null) {
				Item item = service.getItemFromName(itemName);
				Map<Item, Integer> order = new HashMap<>();
				Map<Item, Double> orderSum = new HashMap<>();
				if (session.getAttribute("order") != null) {
					order = (Map<Item, Integer>) session.getAttribute("order");
					orderSum = (Map<Item, Double>) session.getAttribute("orderSum");
				}
				order.compute(item, (k,v)->(v==null)?1:v+1);
				orderSum.compute(item, (k,v)->(v==null)?item.getPrice():v+item.getPrice());
				session.setAttribute("order", order);
				session.setAttribute("orderSum", orderSum);
				session.setAttribute("totalAmount", service.getOrderAmount(order));
			}
		}else if(uri.endsWith("removeitemfromcart.do2")) {
			String itemName = req.getParameter("itemName");
			if (itemName != null) {
				Map<Item, Integer> order = new HashMap<>();
				Map<Item, Double> orderSum = new HashMap<>();
				if (session.getAttribute("order") != null) {
					order = (Map<Item, Integer>) session.getAttribute("order");
					orderSum = (Map<Item, Double>) session.getAttribute("orderSum");
					Item item = service.getItemFromName(itemName);
					order.remove(item);
					orderSum.remove(item);
				}
				session.setAttribute("order", order);
				session.setAttribute("orderSum", orderSum);
				session.setAttribute("totalAmount", service.getOrderAmount(order));
			}
		}else if(uri.endsWith("removeallitemfromcart.do2")) {
			Map<Item, Integer> order = new HashMap<>();
			Map<Item, Double> orderSum = new HashMap<>();
			session.setAttribute("order", order);
			session.setAttribute("orderSum", orderSum);
			session.setAttribute("totalAmount", service.getOrderAmount(order));
		}else if(uri.endsWith("logout.do2")) {
			if(session != null) {
				session.invalidate();
				resp.sendRedirect("*.do2");
				return;
			}
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/itemsPlus.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
