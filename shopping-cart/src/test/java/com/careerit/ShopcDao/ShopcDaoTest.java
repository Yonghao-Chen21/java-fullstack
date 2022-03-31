package com.careerit.ShopcDao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.careerit.shopc.dao.ShopcDaoImpl;
import com.careerit.shopc.domain.Item;

public class ShopcDaoTest {
	@Test
	public void getItemTest() {
		ShopcDaoImpl dao = ShopcDaoImpl.getInstance();
		List<Item> items = dao.loadItems();
		int expected = 5;
		assertEquals(expected, items.size());
	}

	@Test
	public void getItemByNameTest() {
		ShopcDaoImpl dao = ShopcDaoImpl.getInstance();
		Item item = dao.loadItemFromName("Football");
		double expected = 25;
		assertEquals(expected, item.getPrice());
	}
}
