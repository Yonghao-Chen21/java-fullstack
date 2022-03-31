package com.careerit.shopc.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.careerit.shopc.domain.Item;

public enum CsvReaderUtil {
	obj;

	public List<Item> loadItems() {
		List<Item> list = new ArrayList<Item>();
		try {
			List<String> dlist = Files.readAllLines(Paths.get(CsvReaderUtil.class.getResource("/items.csv").toURI()));
			for (int i = 1; i < dlist.size(); i++) {
				String[] data = dlist.get(i).split(",");
				String name = data[0];
				double price = Double.parseDouble(data[1]);
				Item item = Item.builder().name(name).price(price).build();
				list.add(item);
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return list;
	}
}
