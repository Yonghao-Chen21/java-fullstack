package com.careerit.sl.service;

import java.util.List;

import com.careerit.sl.dto.TeamDto;

public interface TeamService {

	
		public TeamDto addTeam(TeamDto teamDto);
		public List<TeamDto> getTeams();
}
