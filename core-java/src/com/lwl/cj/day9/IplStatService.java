package com.lwl.cj.day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IplStatService {

	private Player[] players;

	IplStatService() {
		this.players = loadPlayers();
	}

	private boolean search(String[] arr, int key) {
		// Logic

		return true;
	}

	private String[] teamNames() {
		String[] arr = new String[players.length];
		int c = 0;
		for (Player p : players) {
			String teamName = p.getTeam();
			// Logic

		}
		String[] temp = new String[c];
		System.arraycopy(arr, 0, temp, 0, c);
		return temp;
	}

	public void showPlayers(String teamName) {
		// TODO
	}

	public void showStats(String teamName) {

		// Max
		// Min
		// Count
	}

	public void teamStat() {
		// Each team total amount count average
		// CSK - 8999999 - 22 - 400000
	}

	public void showAllPlayers() {
		for (Player p : players) {
			p.showInfo();
		}
	}

	private Player[] loadPlayers() {
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

		IplStatService obj = new IplStatService();
		obj.showAllPlayers();
	}

}
