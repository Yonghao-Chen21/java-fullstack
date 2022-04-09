package com.careerit.sl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerit.sl.dto.TeamRoleAmountDTO;
import com.careerit.sl.dto.RoleAmountDto;
import com.careerit.sl.dto.TeamAmountDTO;
import com.careerit.sl.repo.TeamDetailsRepo;

@Service
public class IplStatServiceImpl implements IplStatService {

	@Autowired
	private TeamDetailsRepo teamDetailsRepo;
	@Override
	public List<TeamAmountDTO> getTeamAmount() {
		return teamDetailsRepo.getTeamAmountDetails();
	}
	@Override
	public List<RoleAmountDto> getRoleAmount() {
		return teamDetailsRepo.getRoleAmountDetails();
	}
	@Override
	public List<TeamRoleAmountDTO> getRoleAmountEachTeamDetails() {
		return teamDetailsRepo.getRoleAmountEachTeamDetails();
	}

}
