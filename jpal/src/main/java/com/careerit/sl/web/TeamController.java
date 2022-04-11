package com.careerit.sl.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.sl.dto.TeamReqDto;
import com.careerit.sl.service.TeamService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/team")
@Slf4j
public class TeamController {
	
	private TeamService service;
	
	@Autowired
	TeamController(final TeamService service){
		this.service = service;
	}
	
	@PostMapping
	public TeamReqDto addTeam(@RequestBody TeamReqDto t) {
		return service.addTeam(t);
	}
	
	@GetMapping("/all")
	public List<TeamReqDto> getTeams(){
		return service.getTeams();
	}
	
	@GetMapping("/get/{id}")
	public TeamReqDto getTeam(@PathVariable("id") Long id){
		return service.getTeam(id);
	}

	@PutMapping("/update")
	public TeamReqDto updateTeam(@RequestBody TeamReqDto t) {
		return service.updateTeam(t);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteTeam(@PathVariable("id") Long tid) {
		boolean res = service.removeTeam(tid);
		return res ? "Team is deleted" : "Team is not found for given id";
	}

	@GetMapping("/search")
	public List<TeamReqDto> search(HttpServletRequest request) {
		String str = request.getParameter("str");
		log.info("Search String is :{}",str);
		return service.search(str);
	}

}
