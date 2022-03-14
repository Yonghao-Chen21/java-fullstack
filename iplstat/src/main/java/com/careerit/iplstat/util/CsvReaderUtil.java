package com.careerit.iplstat.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.careerit.iplstat.domain.Player;

public final class CsvReaderUtil {
	private CsvReaderUtil(){
		
	}
	
	public static List<Player> getPlayers() {
		List<Player> rs = new ArrayList<Player>();
		try {
			List<String> tmp = Files.readAllLines(Paths.get("ipl_2022_data.csv"));
			for(int i = 1;i<tmp.size();i++) {
				String[] data = tmp.get(i).split(",");
				String name = data[0];
				String role = data[1];
				double price = Double.parseDouble(data[2]);
				String country = data[3];
				String team = data[4];
				rs.add(new Player(name,role,price,country,team));
			}
			
		}catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return rs;
	}

}
