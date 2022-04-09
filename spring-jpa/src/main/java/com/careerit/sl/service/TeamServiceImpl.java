package com.careerit.sl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.careerit.sl.domain.TeamDetails;
import com.careerit.sl.dto.TeamDto;
import com.careerit.sl.repo.TeamDetailsRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TeamServiceImpl implements TeamService {

	private TeamDetailsRepo teamDetailsRepo;

	@Autowired
	public TeamServiceImpl(TeamDetailsRepo teamDetailsRepo) {
		this.teamDetailsRepo = teamDetailsRepo;
	}

	@Override
	public TeamDto addTeam(TeamDto teamDto) {
		Assert.notNull(teamDto, "Team details can't be null");
		Assert.hasText(teamDto.getTeamCode(), "Team code can't be empty or null");
		Assert.hasText(teamDto.getTeamName(), "Team name can't be empty or null");
		TeamDetails teamDetails = Mapper.teamDtoToDomain(teamDto);
		teamDetails = teamDetailsRepo.save(teamDetails);
		log.info("Team is added with id :{}", teamDetails.getId());
		return Mapper.teamDomainToDto(teamDetails);

	}

	@Override
	public List<TeamDto> getTeams() {
		List<TeamDetails> list = teamDetailsRepo.findAll();
		List<TeamDto> teamList = list.stream().map(t -> Mapper.teamDomainToDto(t)).collect(Collectors.toList());
		log.info("Total team count is :{}", teamList.size());
		return teamList;
	}

}
