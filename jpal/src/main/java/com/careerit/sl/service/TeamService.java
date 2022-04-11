package com.careerit.sl.service;

import java.util.List;

import com.careerit.sl.dto.TeamReqDto;


public interface TeamService {
	public TeamReqDto addTeam(TeamReqDto teamDto);
	public TeamReqDto getTeam(Long tid);
	public List<TeamReqDto> getTeams();
	public TeamReqDto updateTeam(TeamReqDto TeamDto);
	public boolean removeTeam(Long tid);
	public List<TeamReqDto> search(String str);
}
