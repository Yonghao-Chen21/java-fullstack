package com.careerit.sl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.sl.dto.TeamRoleAmountDTO;
import com.careerit.sl.dto.RoleAmountDto;
import com.careerit.sl.dto.TeamAmountDTO;
import com.careerit.sl.service.IplStatService;

@RestController
@RequestMapping("/stats")
public class IplStatController {

	@Autowired
	private IplStatService iplStatService;

	@GetMapping("/teamamount")
	public List<TeamAmountDTO> getTeamAmountDetails() {
		return iplStatService.getTeamAmount();
	}
	
	@GetMapping("/roleamount")
	public List<RoleAmountDto> getRoleAmountDetails() {
		return iplStatService.getRoleAmount();
	}
	@GetMapping("/roleamountofteams")
	public List<TeamRoleAmountDTO> getRoleAmountEachTeamDetails() {
		return iplStatService.getRoleAmountEachTeamDetails();
	}
}
