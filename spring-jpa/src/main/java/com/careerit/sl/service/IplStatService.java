package com.careerit.sl.service;

import java.util.List;

import com.careerit.sl.dto.RoleAmountDto;
import com.careerit.sl.dto.TeamAmountDTO;
import com.careerit.sl.dto.TeamRoleAmountDTO;

public interface IplStatService {

		public List<TeamAmountDTO> getTeamAmount();
		public List<RoleAmountDto> getRoleAmount();
		public List<TeamRoleAmountDTO> getRoleAmountEachTeamDetails();
}
