package com.careerit.sl.service;

import com.careerit.sl.domain.TeamDetails;
import com.careerit.sl.dto.TeamDto;

public class Mapper {

	public static TeamDetails teamDtoToDomain(TeamDto teamDto) {
		TeamDetails obj = new TeamDetails();
		obj.setTeamCode(teamDto.getTeamCode());
		obj.setTeamName(teamDto.getTeamName());
		return obj;
	}
	public static TeamDto teamDomainToDto(TeamDetails teamDetails) {
		TeamDto obj = new TeamDto();
		obj.setTeamCode(teamDetails.getTeamCode());
		obj.setTeamName(teamDetails.getTeamName());
		return obj;
	}
}
