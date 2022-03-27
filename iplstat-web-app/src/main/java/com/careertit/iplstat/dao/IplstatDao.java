package com.careertit.iplstat.dao;

import java.util.List;

import com.careertit.iplstat.dto.TeamStatDto;

public interface IplstatDao {

		public List<String> selectTeamNames();
		public List<TeamStatDto> selectTeamStats();
}
