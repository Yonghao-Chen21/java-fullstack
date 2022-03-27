package com.careertit.iplstat.service;

import java.util.List;

import com.careertit.iplstat.dto.TeamStatDto;

public interface IplStatService {
	public List<String> getTeamNames();
	public List<TeamStatDto> getTeamStats();
}
