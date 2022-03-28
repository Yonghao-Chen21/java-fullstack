package com.careertit.iplstat.dao;

import java.util.List;

import com.careertit.iplstat.domain.Player;
import com.careertit.iplstat.dto.RoleAmountDTO;
import com.careertit.iplstat.dto.TeamStatDto;

public interface IplstatDao {

		public List<String> selectTeamCodes();
		public List<TeamStatDto> selectTeamStats();
		public List<Player> getPlayers(String teamCode);
		public List<RoleAmountDTO> getRoleAmount(String teamCode);
		public List<Player> searchPlayer(String name);
}
