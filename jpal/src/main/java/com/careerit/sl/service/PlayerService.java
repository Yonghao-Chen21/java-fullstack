package com.careerit.sl.service;

import java.util.List;
import java.util.Map;

import com.careerit.sl.dto.PlayerDTO;
import com.careerit.sl.dto.RoleCountDTO;
import com.careerit.sl.dto.TeamAmountByRoleDTO;
import com.careerit.sl.dto.TeamAmountDTO;
import com.careerit.sl.dto.TeamDTO;

public interface PlayerService {
	public List<String> getTeamLabels();

	public List<PlayerDTO> getPlayerByTeam(String label);

	public List<RoleCountDTO> getCountByRole(String label);

	public List<PlayerDTO> getPlayerByTeamAndRole(String label, String role);

	public List<TeamDTO> getAllTeamDetails();

	public List<TeamAmountDTO> getAmountSpentByTeams();

	public List<TeamAmountByRoleDTO> getAmountSpentByTeamAndRole(String label);

	public List<PlayerDTO> getPlayersBySort(String fieldName);

	public Map<String, List<PlayerDTO>> getMaxPaidPlayersByRole();

}
