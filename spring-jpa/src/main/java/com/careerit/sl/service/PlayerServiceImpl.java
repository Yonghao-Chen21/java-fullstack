package com.careerit.sl.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.careerit.sl.domain.Player;
import com.careerit.sl.domain.TeamDetails;
import com.careerit.sl.dto.PlayerRequestDto;
import com.careerit.sl.repo.PlayerRepo;
import com.careerit.sl.repo.TeamDetailsRepo;

@Service
public class PlayerServiceImpl implements PlayerService {

	private TeamDetailsRepo teamDetailsRepo;
	private PlayerRepo playerRepo;

	public PlayerServiceImpl(TeamDetailsRepo teamDetailsRepo, PlayerRepo playerRepo) {
		this.teamDetailsRepo = teamDetailsRepo;
		this.playerRepo = playerRepo;
	}

	@Override
	public PlayerRequestDto addPlayer(PlayerRequestDto playerRequestDto) {
		// Validation

		Optional<TeamDetails> optTeam = teamDetailsRepo.findById(playerRequestDto.getTeamId());
		if (optTeam.isPresent()) {
			TeamDetails teamDetails = optTeam.get();
			// Convert dto to domain
			Player player = null;
			player.setTeamDetails(teamDetails);
			playerRepo.save(player);
			// Convert domain to dto
			return playerRequestDto;
		}

		throw new IllegalArgumentException("Team not found with given id :" + playerRequestDto.getTeamId());
	}

}
