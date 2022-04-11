package com.careerit.sl.service;

import java.util.List;
import java.util.Map;

import com.careerit.sl.dto.FeaturedAmountByLabelDto;
import com.careerit.sl.dto.PlayerReqDto;
import com.careerit.sl.dto.PlayerWithTeamDetailsDto;
import com.careerit.sl.dto.RoleAmountDto;
import com.careerit.sl.dto.RoleCountDto;
import com.careerit.sl.dto.TeamAmountByRoleDto;
import com.careerit.sl.dto.TeamAmountDto;
import com.careerit.sl.dto.TeamRoleCountAmountDto;

public interface IplStatService {
	public List<String> getTeamLabels();

	public List<PlayerReqDto> getPlayerByTeam(String label);

	public List<RoleCountDto> getCountByRole(String label);
	
	public List<RoleAmountDto> getAmountSpentByRoles();

	public List<PlayerReqDto> getPlayerByTeamAndRole(String label, String role);

	public List<TeamAmountDto> getAmountSpentPerTeams();

	public List<PlayerReqDto> getPlayersBySort(String fieldName);

	public Map<String, List<PlayerReqDto>> getMaxPaidPlayersByRole();
	
	public List<TeamAmountByRoleDto> getAmountSpentPerTeamRoles();
	
	public List<TeamRoleCountAmountDto> getTeamRoleCountAmountSpentByRoles(String label);
	
	public List<FeaturedAmountByLabelDto> getFeaturedAmountByLabelDto(String label);
	
	public List<PlayerWithTeamDetailsDto> getPlayerWtihTeamDetails();
	
}
