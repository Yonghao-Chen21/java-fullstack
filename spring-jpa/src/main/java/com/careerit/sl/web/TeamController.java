package com.careerit.sl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.sl.dto.TeamDto;
import com.careerit.sl.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@PostMapping
	public TeamDto addTeam(@RequestBody TeamDto teamDto) {
		return teamService.addTeam(teamDto);
	}

	@GetMapping("/all")
	public List<TeamDto> getTeams() {
		return teamService.getTeams();
	}
}
