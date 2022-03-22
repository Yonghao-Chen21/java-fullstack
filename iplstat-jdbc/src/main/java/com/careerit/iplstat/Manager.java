package com.careerit.iplstat;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.careerit.iplstat.domain.Player;
import com.careerit.iplstat.domain.PlayerRole;
import com.careerit.iplstat.dto.PlayerTeamDTO;
import com.careerit.iplstat.dto.RoleAmountDTO;
import com.careerit.iplstat.service.IplStatServiceImpl;

public class Manager {

	public static void main(String[] args) throws SQLException {
		IplStatServiceImpl obj = new IplStatServiceImpl();
		// get players
		List<Player> players = obj.getPlayers("GT", "ALL_ROUNDER", "India");
		System.out.println("Total count: " + players.size());
		players.stream().forEach(System.out::println);
		System.out.println("---------------------");
		// get max paid player(s)
		List<Player> maxplayers = obj.getMaxPaidPlayers("GT", "ALL_ROUNDER");
		maxplayers.stream().forEach(System.out::println);
		System.out.println("---------------------");
		// get amount spent by each role
		Map<PlayerRole, Double> spentByRole = obj.getAmountSpentByEachRole("GT");
		spentByRole.entrySet().forEach(System.out::println);
		System.out.println("---------------------");
		// get players sort by amount
		List<Player> sortedplayers = obj.getAllPlayersSortByAmount();
		sortedplayers.forEach(System.out::println);
		System.out.println("---------------------");
		// get Team RoleAmount
		Map<String, List<RoleAmountDTO>> teamRoleAMount = obj.getTeamRoleAmount();
		teamRoleAMount.entrySet().forEach(System.out::println);
		System.out.println("---------------------");
		// get players with details
		List<PlayerTeamDTO> playerDTO = obj.getPlayerWithTeamDetails();
		playerDTO.forEach(System.out::println);

	}
}
