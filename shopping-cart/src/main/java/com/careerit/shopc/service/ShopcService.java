package com.careerit.shopc.service;

import java.util.List;
import java.util.Map;

import com.careerit.shopc.domain.Item;

interface ShopcService {
	public List<Item> getItems();
	public Item getItemFromName(String name);
	public double getItemAmount(Item item,Integer count);
	public double getOrderAmount(Map<Item,Integer> order);

}
