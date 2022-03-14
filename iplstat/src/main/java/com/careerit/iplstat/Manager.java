package com.careerit.iplstat;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.careerit.iplstat.domain.Player;
import com.careerit.iplstat.dto.RoleAmountDTO;
import com.careerit.iplstat.service.IplStatServiceImpl;

public class Manager {

	public static void main(String[] args) {
		IplStatServiceImpl obj = new IplStatServiceImpl();
		// unique roles
		Set<String> teams = obj.getUniqueTypes("role");
		teams.forEach(System.out::println);
		System.out.println("---------------------");
		// get players
		List<Player> players = obj.getPlayers("GT", "All-rounder", "India");
		System.out.println("Total count: " + players.size());
		players.stream().forEach(System.out::println);
		System.out.println("---------------------");
		// get max paid player(s)
		List<Player> maxplayers = obj.getMaxPaidPlayers("GT", "All-rounder");
		maxplayers.stream().forEach(System.out::println);
		System.out.println("---------------------");
		// get amount spent by each role
		Map<String, Double> spentByRole = obj.getAmountSpentByEachRole();
		spentByRole.entrySet().forEach(System.out::println);
		System.out.println("---------------------");
		// get players sort by amount
		List<Player> sortedplayers = obj.getPlayersSortByAmount("GT");
		sortedplayers.forEach(System.out::println);
		System.out.println("---------------------");
		// get Team RoleAmount
		Map<String, List<RoleAmountDTO>> teamRoleAMount = obj.getTeamRoleAmount();
		teamRoleAMount.entrySet().forEach(System.out::println);

	}
}
