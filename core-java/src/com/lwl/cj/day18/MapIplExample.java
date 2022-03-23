package com.lwl.cj.day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lwl.cj.day9.Player;

public class MapIplExample {

	private static Player[] loadPlayers() {
		Player[] arr = null;
		try {
			List<String> list = Files.readAllLines(Paths.get("ipl_2022_data.csv"));
			arr = new Player[list.size() - 1];
			int c = 0;
			for (int i = 1; i < list.size(); i++) {
				String[] data = list.get(i).split(",");
				String name = data[0];
				String role = data[1];
				double price = Double.parseDouble(data[2]);
				String country = data[3];
				String team = data[4];
				arr[c++] = new Player(name, role, price, country, team);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arr;
	}

	public static void main(String[] args) {

			Player[] arr = loadPlayers();
			
			Map<String,List<Player>> map = new HashMap<>();
			
			for(Player ele:arr) {
					String teamName = ele.getTeam();
					map.putIfAbsent(teamName, new ArrayList<Player>());
					List<Player> list = map.get(teamName);
					list.add(ele);
			}
			
			// Display team name and player count
			
			map.entrySet().forEach(ele->{
				System.out.println(ele.getKey()+" "+ele.getValue().size());
			});
			
			// Display total amount spent by each team
			
			map.entrySet().forEach(entry->{
					String teamName = entry.getKey();
					double sum = entry.getValue().stream().mapToDouble(p->p.getPrice()).sum();
		     		System.out.println(teamName +" Rs: "+NumberFormat.getInstance().format(sum));
		     		// format number : NumberFormat.getInstance().format(num)
			});
			
			// Get total amount spent by all the teams
			
			double sum = map.values().stream()
									 .flatMap(ele->ele.stream()) // flatMap(ele->ele.stream()). it makes the ele to stream
									 .collect(Collectors.toList())
				                     .stream()
				                     .mapToDouble(p->p.getPrice()).sum();
			                    
			
			System.out.println("Rs: "+NumberFormat.getInstance().format(sum));
			
	}
}
