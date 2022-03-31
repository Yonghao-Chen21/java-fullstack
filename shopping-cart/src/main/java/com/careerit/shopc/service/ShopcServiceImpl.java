package com.careerit.shopc.service;

import java.util.List;
import java.util.Map;

import com.careerit.shopc.dao.ShopcDaoImpl;
import com.careerit.shopc.domain.Item;

public class ShopcServiceImpl implements ShopcService {
	private ShopcDaoImpl dao = ShopcDaoImpl.getInstance();

	@Override
	public List<Item> getItems() {
		List<Item> items = dao.loadItems();
		return items;
	}

	@Override
	public Item getItemFromName(String name) {
		Item item = dao.loadItemFromName(name);
		return item;
	}

	@Override
	public double getItemAmount(Item item, Integer count) {
		return item.getPrice() * count;
	}

	@Override
	public double getOrderAmount(Map<Item, Integer> order) {
		double sum = 0;
		for (Item item : order.keySet()) {
			sum += item.getPrice() * order.get(item);
		}
		return sum;
	}

}
