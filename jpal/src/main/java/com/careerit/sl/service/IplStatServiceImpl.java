package com.careerit.sl.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerit.sl.domain.Player;
import com.careerit.sl.domain.Team;
import com.careerit.sl.dto.FeaturedAmountByLabelDto;
import com.careerit.sl.dto.PlayerReqDto;
import com.careerit.sl.dto.PlayerWithTeamDetailsDto;
import com.careerit.sl.dto.RoleAmountDto;
import com.careerit.sl.dto.RoleCountDto;
import com.careerit.sl.dto.TeamAmountByRoleDto;
import com.careerit.sl.dto.TeamAmountDto;
import com.careerit.sl.dto.TeamRoleCountAmountDto;
import com.careerit.sl.repo.PlayerRepo;
import com.careerit.sl.repo.TeamRepo;

@Service
public class IplStatServiceImpl implements IplStatService {

	private PlayerRepo playerRepo;

	private TeamRepo teamRepo;

	@Autowired
	public IplStatServiceImpl(final PlayerRepo playerRepo, final TeamRepo teamRepo) {
		this.playerRepo = playerRepo;
		this.teamRepo = teamRepo;
	}

	private List<String> getRoles() {
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
	public List<PlayerReqDto> getPlayerByTeam(String label) {
		List<Player> players = playerRepo.findByTeamLabel(label);
		List<PlayerReqDto> rs = players.stream().map(p->Mapper.playerDomainToReqDto(p)).collect(Collectors.toList());
		return rs;
	}

	@Override
	public List<RoleCountDto> getCountByRole(String role) {
		return playerRepo.getCountByRole(role);
	}

	@Override
	public List<PlayerReqDto> getPlayerByTeamAndRole(String label, String role) {
		List<Player> players = playerRepo.findByRoleAndTeamLabel(role, label);
		List<PlayerReqDto> rs = players.stream().map(p->Mapper.playerDomainToReqDto(p)).collect(Collectors.toList());
		return rs;
	}

	@Override
	public List<TeamAmountDto> getAmountSpentPerTeams() {
		return teamRepo.getAmountSpentByTeams();
	}

	@Override
	public List<PlayerReqDto> getPlayersBySort(String fieldName) {
		List<Player> players = new ArrayList<>();
		switch (fieldName) {
		case "name":
			players = playerRepo.findAllByOrderByNameAsc();
			break;
		case "role":
			players = playerRepo.findAllByOrderByRoleAsc();
			break;
		case "price":
			players = playerRepo.findAllByOrderByPriceAsc();
		}
		List<PlayerReqDto> rs = players.stream().map(p->Mapper.playerDomainToReqDto(p)).collect(Collectors.toList());
		return rs;
	}

	@Override
	public Map<String, List<PlayerReqDto>> getMaxPaidPlayersByRole() {
		Map<String, List<PlayerReqDto>> rs = new HashMap<>();
		List<String> roles = getRoles();
		for (String r : roles) {
			List<Player> players = playerRepo.findWithMaxPriceAndByRole(r);
			List<PlayerReqDto> list = players.stream().map(p->Mapper.playerDomainToReqDto(p)).collect(Collectors.toList());
			rs.put(r, list);
		}

		return rs;
	}

	@Override
	public List<RoleAmountDto> getAmountSpentByRoles() {
		return teamRepo.getAmountSpentByRoles();
	}

	@Override
	public List<TeamAmountByRoleDto> getAmountSpentPerTeamRoles() {
		return teamRepo.getAmountSpentPerTeamRoles();
	}

	@Override
	public List<TeamRoleCountAmountDto> getTeamRoleCountAmountSpentByRoles(String label) {
		return teamRepo.getTeamRoleCountAmountSpentByRoles(label);
	}

	@Override
	public List<FeaturedAmountByLabelDto> getFeaturedAmountByLabelDto(String label) {
		return teamRepo.getFeaturedAmountByLabelDto(label);
	}
	
	@Override
	public List<PlayerWithTeamDetailsDto> getPlayerWtihTeamDetails(){
		return playerRepo.getPlayerWtihTeamDetails();
	}



}
