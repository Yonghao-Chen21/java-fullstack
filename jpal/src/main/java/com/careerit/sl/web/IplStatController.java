package com.careerit.sl.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.sl.dto.FeaturedAmountByLabelDto;
import com.careerit.sl.dto.PlayerReqDto;
import com.careerit.sl.dto.PlayerWithTeamDetailsDto;
import com.careerit.sl.dto.RoleAmountDto;
import com.careerit.sl.dto.TeamAmountByRoleDto;
import com.careerit.sl.dto.TeamAmountDto;
import com.careerit.sl.dto.TeamRoleCountAmountDto;
import com.careerit.sl.service.IplStatService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/stat")
@Slf4j
public class IplStatController {
	
	
	private IplStatService service;
	
	@Autowired
	IplStatController(final IplStatService service){
		this.service = service;
	}
		
	@GetMapping("/playersbylabel")
	public List<PlayerReqDto> getPlayerByLabel(@RequestParam String label) {
		log.info("Search team code is :{}",label);
		return service.getPlayerByTeam(label);
	}
	
	@GetMapping("/amountperlabel")
	public List<TeamAmountDto> getAmountPerLabel() {
		return service.getAmountSpentPerTeams();
	}
	
	@GetMapping("/amountperrole")
	public List<RoleAmountDto> getAmountPerRole() {
		return service.getAmountSpentByRoles();
	}
	
	@GetMapping("/amountperteamrole")
	public List<TeamAmountByRoleDto> getAmountSpentPerTeamRoles() {
		return service.getAmountSpentPerTeamRoles();
	}
	
	@GetMapping("/amountcountperteamrole")
	public List<TeamRoleCountAmountDto> getTeamRoleCountAmountSpentByRoles(@RequestParam String label) {
		return service.getTeamRoleCountAmountSpentByRoles(label);
	}	
	
	@GetMapping("/feature")
	public List<FeaturedAmountByLabelDto> getFeaturedAmountByLabelDto(@RequestParam String label) {
		return service.getFeaturedAmountByLabelDto(label);
	}
	
	@GetMapping("/maxamountplayerbyrole")
	public Map<String, List<PlayerReqDto>> getMaxPaidPlayersByRole() {
		return service.getMaxPaidPlayersByRole();
	}
	
	@GetMapping("/playerdetails")
	public List<PlayerWithTeamDetailsDto> getPlayerWtihTeamDetails() {
		return service.getPlayerWtihTeamDetails();
	}
	
}
