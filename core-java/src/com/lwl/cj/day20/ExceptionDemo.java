package com.lwl.cj.day20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Player {
	private String name;
	private String role;
	private double price;
	private String country;
	private String team;
}

public class ExceptionDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		try {
			list = readDataFromCsv();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Total row count    :"+list.size());
		List<Player> playerList = convertStrToPlayer(list);
		System.out.println("Total player count :"+playerList.size());
	}

	private static List<String> readDataFromCsv() throws IOException {
		return Files.readAllLines(Paths.get("data/ipl_2022_data.csv")).stream().skip(1) // Skip headers
				.collect(Collectors.toList());
	}

	private static List<Player> convertStrToPlayer(List<String> list) {
		List<Player> playerList = new ArrayList<Player>();
		list.stream().forEach(ele -> {
			String[] data = ele.split(",");
			String name = data[0];
			String role = data[1];
			double price = Double.parseDouble(data[2]!=null && !data[2].isEmpty()?data[2]:"0");
			String country = data[3];
			String team = data[4];
			playerList.add(new Player(name, role, price, country, team));
		});
		return playerList;

	}

}
