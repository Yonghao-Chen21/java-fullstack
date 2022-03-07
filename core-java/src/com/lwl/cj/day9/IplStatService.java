package com.lwl.cj.day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IplStatService {

	private Player[] players;

	IplStatService() {
		this.players = loadPlayers();
	}

	public String[] listToArray(List<String> ls) {
		String[] rs = new String[ls.size()];
		for (int i = 0; i < rs.length; i++) {
			rs[i] = ls.get(i);
		}
		return rs;

	}

	public String[] getAllTeams() {
		List<String> teams = new ArrayList<>();
		for (Player player : players) {
			String team = player.getTeam();
			if (!teams.contains(team)) {
				teams.add(team);
			}
		}
		String[] rs = listToArray(teams);
		return rs;
	}

	public String[] getTeamMembers(String teamName) {
		List<String> members = new ArrayList<>();
		for (Player player : players) {
			if (player.getTeam().equals(teamName)) {
				members.add(player.getName());
			}
		}
		String[] rs = listToArray(members);
		return rs;
	}

	public void showPlayers(String teamName) {
		String[] teammembers = getTeamMembers(teamName);
		for (String name : teammembers) {
			System.out.println(name);
		}

	}

	public void showStats(String teamName) {
		// Max amount
		double max = 0;
		// Min amount
		double min = 0;
		// Count of members
		int count = 0;
		for (Player player : players) {
			if (player.getTeam().equals(teamName)) {
				double tmp = player.getPrice();
				if(count == 0) {
					max = tmp;
					min = tmp;
				}else {
					max = (tmp > max) ? tmp : max;
					min = (tmp < min) ? tmp : min;
				}
				count++;
			}
		}
		System.out.println("Max price: " + max + ". Min Price: " + min + ". Count of players: " + count + ".");
	}

	public void teamStat() {
		// Each team total amount count average
		// CSK - 8999999 - 22 - 400000
		String[] teams = getAllTeams();
		double[] teamstotal = new double[teams.length];
		int[] teamscount = new int[teams.length];
		double[] teamsavg = new double[teams.length];
		for (Player player : players) {
			for (int i = 0; i < teams.length; i++) {
				if (player.getTeam().equals(teams[i])) {
					teamstotal[i] += player.getPrice();
					teamscount[i]++;
					break;
				}
			}
		}
		System.out.println("Team - Total Price - Count of Members - Avg.Price");
		for (int i = 0; i < teams.length; i++) {
			teamsavg[i] = teamstotal[i] / teamscount[i];
			System.out.println(String.format("%s - %s - %s - %s",teams[i],teamstotal[i],teamscount[i],teamsavg[i]));
		}
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
		String [] teams = obj.getAllTeams();		
		System.out.println(String.join(", ",teams));
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the team name");
		String team = sc.next();
		sc.close();
		obj.teamStat();
		// obj.showAllPlayers();
		obj.showPlayers(team);
		// obj.showStats(team);
		
	}

}
