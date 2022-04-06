package com.careerit.sl.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerit.sl.domain.Player;
import com.careerit.sl.domain.Team;
import com.careerit.sl.dto.PlayerDTO;
import com.careerit.sl.dto.RoleCountDTO;
import com.careerit.sl.dto.TeamAmountByRoleDTO;
import com.careerit.sl.dto.TeamAmountDTO;
import com.careerit.sl.dto.TeamDTO;
import com.careerit.sl.repo.PlayerRepo;
import com.careerit.sl.repo.TeamRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PlayerServiceImpl implements PlayerService {

	private PlayerRepo playerRepo;

	private TeamRepo teamRepo;

	@Autowired
	public PlayerServiceImpl(final PlayerRepo playerRepo, final TeamRepo teamRepo) {
		this.playerRepo = playerRepo;
		this.teamRepo = teamRepo;
	}

	public List<String> getRoles() {
		List<String> roles = new ArrayList<>();
		List<Player> players = playerRepo.findAll();
		for (Player p : players) {
			if (!roles.contains(p.getRole())) {
				roles.add(p.getRole());
			}
		}

		return roles;
	}

	@Override
	public List<String> getTeamLabels() {
		List<Team> teams = teamRepo.findAll();
		List<String> rs = new ArrayList<>();
		for (Team t : teams) {
			rs.add(t.getLabel());
		}
		return rs;
	}

	@Override
	public List<PlayerDTO> getPlayerByTeam(String label) {
		List<Player> players = playerRepo.findAllByTeamCode(label);
		List<PlayerDTO> rs = new ArrayList<>();
		for (Player p : players) {
			rs.add(new PlayerDTO(p.getName(), p.getRole(), p.getPrice()));
		}
		return rs;
	}

	@Override
	public List<RoleCountDTO> getCountByRole(String label) {
		List<RoleCountDTO> rs = new ArrayList<>();
		List<String> roles = getRoles();
		for (String r : roles) {
			int count = playerRepo.countByRoleAndTeamCode(r, label);
			rs.add(new RoleCountDTO(r, count));
		}

		return rs;
	}

	@Override
	public List<PlayerDTO> getPlayerByTeamAndRole(String label, String role) {
		List<PlayerDTO> rs = new ArrayList<>();
		List<Player> players = playerRepo.findByRoleAndTeamCode(role, label);
		for (Player p : players) {
			rs.add(new PlayerDTO(p.getName(), p.getRole(), p.getPrice()));
		}
		return rs;
	}

	@Override
	public List<TeamDTO> getAllTeamDetails() {
		List<Team> teams = teamRepo.findAll();
		List<TeamDTO> rs = new ArrayList<>();
		for (Team t : teams) {
			rs.add(new TeamDTO(t.getCity(), t.getHome(), t.getCoach(), t.getName(), t.getLabel()));
		}
		return rs;
	}

	@Override
	public List<TeamAmountDTO> getAmountSpentByTeams() {
		List<TeamAmountDTO> rs = new ArrayList<>();
		List<String> labels = getTeamLabels();
		for (String l : labels) {
			double amount = 0;
			List<PlayerDTO> players = getPlayerByTeam(l);
			for (PlayerDTO p : players) {
				amount += p.getPrice();
			}
			rs.add(new TeamAmountDTO(l, amount));
		}
		return rs;
	}

	@Override
	public List<TeamAmountByRoleDTO> getAmountSpentByTeamAndRole(String label) {
		List<String> roles = getRoles();
		List<TeamAmountByRoleDTO> rs = new ArrayList<>();
		for (String r : roles) {
			double amount = 0;
			List<PlayerDTO> players = getPlayerByTeamAndRole(label, r);
			for (PlayerDTO p : players) {
				amount += p.getPrice();
			}
			rs.add(new TeamAmountByRoleDTO(label, r, amount));
		}

		return rs;
	}

	@Override
	public List<PlayerDTO> getPlayersBySort(String fieldName) {
		List<Player> players = new ArrayList<>();
		switch (fieldName){
		case "name" :
			players = playerRepo.findAllByOrderByNameAsc();
			break;
		case "role" :
			players = playerRepo.findAllByOrderByRoleAsc();
			break;
		case "price":
			players = playerRepo.findAllByOrderByPriceAsc();		
		}
		List<PlayerDTO> rs = new ArrayList<>();
		for (Player p : players) {
			rs.add(new PlayerDTO(p.getName(), p.getRole(), p.getPrice()));
		}
		return rs;
	}

	@Override
	public Map<String, List<PlayerDTO>> getMaxPaidPlayersByRole() {
		Map<String, List<PlayerDTO>> rs = new HashMap<>();
		List<String> roles = getRoles();
		for (String r:roles) {
			List<PlayerDTO> list = new ArrayList<>();
			List<Player> players = playerRepo.findWithMaxPriceAndByRole(r);
			for (Player p : players) {
				list.add(new PlayerDTO(p.getName(), p.getRole(), p.getPrice()));
			}
			rs.put(r, list);
		}
		
		return rs;
	}

	private List<Team> getTeams() {
		ObjectMapper obj = new ObjectMapper();
		List<Team> teamList = null;
		try {
			teamList = obj.readValue(this.getClass().getResourceAsStream("/ipl2020.json"),
					new TypeReference<List<Team>>() {
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return teamList;
	}

	private List<Player> getPlayers(Team team) {
		for (Player p : team.getPlayers()) {
			p.setTeamCode(team.getLabel());
		}
		return team.getPlayers();
	}

	public void loadToMysql() {
		List<Team> teamList = getTeams();
		teamRepo.saveAll(teamList);
		List<Player> playerList = new ArrayList<>();
		for (Team t : teamList) {
			List<Player> l = getPlayers(t);
			playerList.addAll(l);
		}
		playerRepo.saveAll(playerList);
	}

}
