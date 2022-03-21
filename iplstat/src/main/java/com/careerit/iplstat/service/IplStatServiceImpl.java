package com.careerit.iplstat.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.careerit.iplstat.domain.Player;
import com.careerit.iplstat.dto.RoleAmountDTO;
import com.careerit.iplstat.util.CsvReaderUtil;

public class IplStatServiceImpl implements IplStatService {

	private List<Player> plist;

	public IplStatServiceImpl() {
		super();
		this.plist = CsvReaderUtil.getPlayers();
	}

	public Set<String> getUniqueTypes(String type) {
		List<String> all = new ArrayList<>();
		switch (type) {
		case "name":
			all = plist.stream().map(p -> p.getName()).collect(Collectors.toList());
			break;
		case "role":
			all = plist.stream().map(p -> p.getRole()).collect(Collectors.toList());
			break;
		case "country":
			all = plist.stream().map(p -> p.getCountry()).collect(Collectors.toList());
			break;
		case "team":
			all = plist.stream().map(p -> p.getTeam()).collect(Collectors.toList());
		}
		Set<String> uniques = new HashSet<>();
		for (String ele : all) {
			uniques.add(ele);
		}
		return uniques;
	}

	public List<Player> getPlayers(Predicate<Player> predicate) {
		List<Player> players = plist.stream().filter(p -> predicate.test(p)).collect(Collectors.toList());
		return players;
	}

	@Override
	public List<Player> getPlayers(String teamName) {
		return getPlayers(p -> p.getTeam().equals(teamName));
	}

	@Override
	public List<Player> getPlayers(String teamName, String role) {
		return getPlayers(p -> p.getTeam().equals(teamName) && p.getRole().equals(role));
	}

	@Override
	public List<Player> getPlayers(String teamName, String role, String country) {

		return getPlayers(
				p -> p.getTeam().equals(teamName) && p.getRole().equals(role) && p.getCountry().equals(country));
	}

	public List<Player> getMaxPaidPlayers(List<Player> players) {
		double maxPrice = players.stream().mapToDouble(p -> p.getPrice()).max().getAsDouble();
		List<Player> rs = players.stream().filter(p -> p.getPrice() == maxPrice).collect(Collectors.toList());
		return rs;
	}

	@Override
	public List<Player> getMaxPaidPlayers(String teamName) {
		List<Player> players = getPlayers(teamName);
		return getMaxPaidPlayers(players);
	}

	@Override
	public List<Player> getMaxPaidPlayers(String teamName, String role) {
		List<Player> players = getPlayers(teamName, role);
		return getMaxPaidPlayers(players);
	}

	@Override
	public List<Player> getMaxPaidPlayers() {
		return getMaxPaidPlayers(plist);
	}

	public Map<String, Double> getAmountSpentByEachRole(List<Player> players) {
		Map<String, Double> rs = new HashMap<>();
		for (Player player : players) {
			String role = player.getRole();
			double amount = player.getPrice();
			rs.putIfAbsent(role, (double) 0);
			rs.put(role, rs.get(role) + amount);
		}
		return rs;
	}

	@Override
	public Map<String, Double> getAmountSpentByEachRole(String teamName) {
		List<Player> players = getPlayers(teamName);
		return getAmountSpentByEachRole(players);
	}

	@Override
	public Map<String, Double> getAmountSpentByEachRole() {
		// Get amount spent by each role of the all teams
		return getAmountSpentByEachRole(plist);
	}

	public List<Player> getPlayersSortByAmount(List<Player> players) {
		// Double.valueOf(p1.getPrice()).compareTo(Double.valueOf(p2.getPrice()))
		players.sort(Comparator.comparing(Player::getPrice));
		return players;
	}

	@Override
	public List<Player> getAllPlayersSortByAmount() {
		return getPlayersSortByAmount(plist);
	}

	public List<Player> getPlayersSortByAmount(String teamName) {
		List<Player> players = getPlayers(teamName);
		return getPlayersSortByAmount(players);
	}

	@Override
	public Map<String, List<RoleAmountDTO>> getTeamRoleAmount() {
		Map<String, List<RoleAmountDTO>> rs = new HashMap<>();
		Set<String> teams = getUniqueTypes("team");
		for(String team:teams) {
			List<RoleAmountDTO> tmp = new ArrayList<>();
			Map<String, Double> priceByRole = getAmountSpentByEachRole(team);
			priceByRole.entrySet().forEach(entry->tmp.add(new RoleAmountDTO(entry.getKey(),entry.getValue())));
			rs.put(team,tmp);
		}
		return rs;

	}

}
