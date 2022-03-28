package com.careertit.iplstat.service;

import java.util.List;

import com.careertit.iplstat.dao.IplstatDao;
import com.careertit.iplstat.dao.IplstatDaoImpl;
import com.careertit.iplstat.domain.Player;
import com.careertit.iplstat.dto.RoleAmountDTO;
import com.careertit.iplstat.dto.TeamStatDto;

public class IplStatServiceImpl implements IplStatService {

	private IplstatDao obj = IplstatDaoImpl.getInstance();

	@Override
	public List<String> getTeamNames() {
		List<String> list = obj.selectTeamCodes();
		System.out.println("Total team names count is :" + list.size());
		return list;
	}

	@Override
	public List<TeamStatDto> getTeamStats() {
		List<TeamStatDto> list = obj.selectTeamStats();
		System.out.println("Teams count is :" + list.size());
		return list;
	}

	@Override
	public List<Player> getPlayers(String teamCode) {
		List<Player> list = obj.getPlayers(teamCode);
		System.out.println("Players count is :" + list.size());
		return list;
	}

	@Override
	public List<RoleAmountDTO> getRoleAmount(String teamCode) {
		List<RoleAmountDTO> list = obj.getRoleAmount(teamCode);
		System.out.println("Get Role Amounts");
		return list;
	}

	@Override
	public List<Player> searchPlayer(String name) {
		List<Player> list = obj.searchPlayer(name);
		System.out.println("Players count is :" + list.size());
		return list;
	}

}
