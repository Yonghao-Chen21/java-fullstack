package com.careerit.sl.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.careerit.sl.domain.Team;
import com.careerit.sl.dto.TeamReqDto;
import com.careerit.sl.repo.TeamRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TeamServiceImpl implements TeamService {
	private TeamRepo teamRepo;

	@Autowired
	public TeamServiceImpl(final TeamRepo teamRepo) {
		this.teamRepo = teamRepo;
	}

	@Override
	public TeamReqDto addTeam(TeamReqDto t) {
		Assert.notNull(t, "Team details can't be null.");
		Assert.hasText(t.getName(), "Team name can't be null.");
		Assert.hasText(t.getLabel(), "Team label can't be null.");
		Team team = Mapper.teamReqDtoToDomain(t);
		team = teamRepo.save(team);
		// if successfully saved, tid is here.
		log.info("Team is added with id: {}", team.getId());
		return Mapper.teamDomainToReqDto(team);
	}

	@Override
	public TeamReqDto getTeam(Long tid) {
		Optional<Team> team = teamRepo.findById(tid);
		if (team.isPresent()) {
			return Mapper.teamDomainToReqDto(team.get());
		}
		return null;
	}

	@Override
	public List<TeamReqDto> getTeams() {
		List<Team> teams = teamRepo.findAll();
		List<TeamReqDto> rs = teams.stream().map(t -> Mapper.teamDomainToReqDto(t)).collect(Collectors.toList());
		log.info("Total team count: {}", rs.size());
		return rs;
	}

	@Override
	public TeamReqDto updateTeam(TeamReqDto t) {
		Assert.notNull(t, "Team details can't be null.");
		Assert.hasText(t.getName(), "Team name can't be null.");
		Assert.hasText(t.getLabel(), "Team label can't be null.");
		Optional<Team> optTeam = teamRepo.findById(t.getTid());
		if (optTeam.isPresent()) {
			Team team = optTeam.get();
			team.setCity(t.getCity());
			team.setCoach(t.getCoach());
			team.setHome(t.getHome());
			team.setLabel(t.getLabel());
			team.setName(t.getName());
			team = teamRepo.save(team);
			return Mapper.teamDomainToReqDto(team);
		}
		return null;
	}

	@Override
	public boolean removeTeam(Long tid) {
		Optional<Team> optTeam = teamRepo.findById(tid);
		if (optTeam.isPresent()) {
			Team team = optTeam.get();
			teamRepo.delete(team);
			return true;
		}
		return false;
	}

	@Override
	public List<TeamReqDto> search(String str) {
		List<Team> teams = teamRepo.searchByNameLike(str);
		List<TeamReqDto> rs = teams.stream().map(t->Mapper.teamDomainToReqDto(t)).collect(Collectors.toList());
		log.info("For given search str :{} the matched record count is:{}", str, rs.size());
		return rs;
	}

}
