package com.careerit.iplstat.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.careerit.iplstat.domain.Player;
import com.careerit.iplstat.domain.PlayerRole;

public enum CsvReaderUtil {
	obj;

	public List<Player> loadPlayers() {
		List<Player> list = new ArrayList<Player>();
		try {
			List<String> dlist = Files.readAllLines(Paths.get(CsvReaderUtil.class.getResource("/ipl_2022_data.csv").toURI()));
			for (int i = 1; i < dlist.size(); i++) {
				String[] data = dlist.get(i).split(",");
				String name = data[0];
				PlayerRole role = PlayerRole.valueOf(data[1].toUpperCase().replace("-", "_"));
				double price = Double.parseDouble(data[2]);
				String country = data[3];
				String team = data[4];
				Player player = Player.builder().name(name)
						                        .role(role)
						                        .price(price)
						                        .country(country)
						                        .team(team)
						                        .build();
				list.add(player);
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return list;
	}
}
