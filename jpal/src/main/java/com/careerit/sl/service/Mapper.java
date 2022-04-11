package com.careerit.sl.service;

import com.careerit.sl.domain.Player;
import com.careerit.sl.domain.Team;
import com.careerit.sl.dto.PlayerReqDto;
import com.careerit.sl.dto.TeamReqDto;

public class Mapper {
	public static Team teamReqDtoToDomain(TeamReqDto t) {
		Team obj = new Team();
		obj.setCity(t.getCity());
		obj.setCoach(t.getCoach());
		obj.setHome(t.getHome());
		obj.setLabel(t.getLabel());
		obj.setName(t.getName());
		return obj;	
	}
	
	public static TeamReqDto teamDomainToReqDto(Team t) {
		TeamReqDto obj = new TeamReqDto();
		obj.setTid(t.getId());
		obj.setCity(t.getCity());
		obj.setCoach(t.getCoach());
		obj.setHome(t.getHome());
		obj.setLabel(t.getLabel());
		obj.setName(t.getName());
		return obj;	
	}
	
	public static Player playerReqDtoToDomainWOTeam(PlayerReqDto p) {
		Player obj = new Player();
		obj.setName(p.getName());
		obj.setPrice(p.getPrice());
		obj.setRole(p.getRole());
		return obj;	
	}
	
	public static PlayerReqDto playerDomainToReqDto(Player p) {
		PlayerReqDto obj = new PlayerReqDto();
		obj.setName(p.getName());
		obj.setPid(p.getId());
		obj.setPrice(p.getPrice());
		obj.setRole(p.getRole());
		obj.setTid(p.getTeam().getId());
		return obj;	
	}

}
