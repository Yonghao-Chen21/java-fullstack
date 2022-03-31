package com.careerit.shopc.dao;

import java.util.List;

import com.careerit.shopc.domain.Item;

interface ShopcDao {
	public List<Item> loadItems();
	public Item loadItemFromName(String name);

}
