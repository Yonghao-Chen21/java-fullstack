package com.careerit.ipl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public enum CsvReaderUtil {
	obj;

	public List<Player> loadPlayers() {
		List<Player> list = new ArrayList<Player>();
		try {
			List<String> dlist = Files.readAllLines(Paths.get(CsvReaderUtil.class.getResource("/player_data.csv").toURI()));
			for (int i = 1; i < dlist.size(); i++) {
				String[] data = dlist.get(i).split(",");
				String name = data[0];
				String role = data[1];
				double price = Double.parseDouble(data[2]);
				String country = data[3];
				String team = data[4];
				Player player = new Player(name, role, price, country, team);
				list.add(player);
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return list;
	}
}
