package com.lwl.cj.day15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class CsvReaderUtil {

	public static List<Player> getPlayers() {
		List<Player> list = new ArrayList<Player>();
		try {
			List<String> l = Files.readAllLines(Paths.get("ipl_2022_data.csv"));
			for (int i = 1; i < l.size(); i++) {
				String[] data = l.get(i).split(",");
				String name = data[0];
				String role = data[1];
				double price = Double.parseDouble(data[2]);
				String country = data[3];
				String team = data[4];
				list.add(new Player(name, role, price, country, team));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
