package com.lwl.cj.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlayerStat {

	public static void main(String[] args) {

		List<Player> players = readPlayersFromCSV("ipl_2022_data.csv");
		/*
		 * for(Player p:players) { System.out.println(p.name+" "+p.price); }
		 */

		// Find average price

		// Max price and Min price

		showAttributeSpent(players, "Team");
		// showAttributeSpent(players,"Player");
	}

	public static void showMax(List<Player> players) {
		double max = players.get(0).price;
		double min = players.get(0).price;
		for (int i = 1; i < players.size(); i++) {
			if (max < players.get(0).price) {
				max = players.get(i).price;
			}
			if (min > players.get(i).price) {
				min = players.get(i).price;
			}
		}
		System.out.println("Max price :" + max);
	}

	public static List<String> uniqueattribute(List<Player> players, String attribute) {
		List<String> ls = new ArrayList<>();
		for (Player player : players) {
			if (!ls.contains(player.getattribute(attribute))) {
				ls.add(player.getattribute(attribute));
			}
		}
		return ls;
	}

	public static void showAttributeSpent(List<Player> players, String attribute) {

		List<String> ls = uniqueattribute(players,attribute);

		double[] lsspent = new double[ls.size()];
		for (Player player : players) {
			for (int i = 0; i < ls.size(); i++) {
				if (ls.get(i).equals(player.getattribute(attribute))) {
					// don't use ==. different references
					lsspent[i] += player.price;
					break;
				}
			}
		}
		
		double maxprice = lsspent[0];
		String topattr = "";
		for (int i = 1; i < lsspent.length; i++) {
			if (maxprice < lsspent[i]) {
				maxprice = lsspent[i];
				topattr = ls.get(i);
			}
		}

		for (int i = 0; i < ls.size(); i++) {
			System.out.println(attribute + " Name :" + ls.get(i) + ", " + attribute + " Spent :" + lsspent[i] + ".");
		}

		System.out.println("");
		System.out.println("Top " + attribute + " Name :" + topattr + ", " + attribute + " Spent :" + maxprice + ".");

	}

	private static List<Player> readPlayersFromCSV(String fileName) {
		List<Player> players = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);

		// create an instance of BufferedReader
		// using try with resource, Java 7 feature to close resources
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

			// read the first line from the text file
			String line = br.readLine();
			line = br.readLine();
			// loop until all lines are read
			while (line != null) {
				String[] attributes = line.split(",");
				Player player = createPlayer(attributes);

				// adding book into ArrayList
				players.add(player);

				// read next line before looping
				// if end of file reached, line would be null
				line = br.readLine();

			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return players;
	}

	private static Player createPlayer(String[] attributes) {
		String name = attributes[0];
		String role = attributes[1];
		double price = Double.parseDouble(attributes[2]);
		String country = attributes[3];
		String team = attributes[4];
		Player player = new Player(name, role, price, country, team);
		return player;

	}

}
