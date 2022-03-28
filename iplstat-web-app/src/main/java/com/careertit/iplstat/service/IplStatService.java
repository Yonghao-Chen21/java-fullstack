package com.careertit.iplstat.service;

import java.util.List;

import com.careertit.iplstat.domain.Player;
import com.careertit.iplstat.dto.RoleAmountDTO;
import com.careertit.iplstat.dto.TeamStatDto;

public interface IplStatService {
	public List<String> getTeamNames();
	public List<TeamStatDto> getTeamStats();
	public List<Player> getPlayers(String teamCode);
	public List<RoleAmountDTO> getRoleAmount(String teamCode);
	public List<Player> searchPlayer(String name);
}
