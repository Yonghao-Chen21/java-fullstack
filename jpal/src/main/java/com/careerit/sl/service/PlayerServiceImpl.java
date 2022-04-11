package com.careerit.sl.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.careerit.sl.domain.Player;
import com.careerit.sl.dto.PlayerReqDto;
import com.careerit.sl.repo.PlayerRepo;
import com.careerit.sl.repo.TeamRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService{
	
	private PlayerRepo playerRepo;
	private TeamRepo teamRepo;

	@Autowired
	public PlayerServiceImpl(final PlayerRepo playerRepo, final TeamRepo teamRepo) {
		this.playerRepo = playerRepo;
		this.teamRepo = teamRepo;
	}

	@Override
	public PlayerReqDto addPlayer(PlayerReqDto p) {
		Assert.notNull(p, "Player details can't be null.");
		Assert.hasText(p.getName(), "Name can't be null.");
		Assert.notNull(p.getTid(), "Team id can't be null.");
		Player player = Mapper.playerReqDtoToDomainWOTeam(p);
		player.setTeam(teamRepo.findById(p.getTid()).get());
		player = playerRepo.save(player);
		log.info("Player is added with id: {}", player.getId());
		return Mapper.playerDomainToReqDto(player);
	}

	@Override
	public PlayerReqDto getPlayer(Long pid) {
		Optional<Player> optPlayer = playerRepo.findById(pid);
		if(optPlayer.isPresent()) {
			return Mapper.playerDomainToReqDto(optPlayer.get());
		}
		return null;
	}

	@Override
	public List<PlayerReqDto> getPlayers() {
		List<Player> players = playerRepo.findAll();
		List<PlayerReqDto> rs = players.stream().map(p->Mapper.playerDomainToReqDto(p)).collect(Collectors.toList());
		return rs;
	}

	@Override
	public PlayerReqDto updatePlayer(PlayerReqDto p) {
		Optional<Player> optPlayer = playerRepo.findById(p.getPid());
		if(optPlayer.isPresent()) {
			Player player = optPlayer.get();
			if(p.getName() != null) {
				player.setName(p.getName());				
			}
			if(p.getPrice() != 0) {
				player.setPrice(p.getPrice());				
			}
			if(p.getRole() != null) {
				player.setRole(p.getRole());				
			}
			if(p.getTid() != 0) {
				player.setTeam(teamRepo.findById(p.getTid()).get());
			}
			playerRepo.save(player);
			return Mapper.playerDomainToReqDto(player);
		}
		return null;
	}

	@Override
	public boolean removePlayer(Long pid) {
		Optional<Player> optPlayer = playerRepo.findById(pid);
		if(optPlayer.isPresent()) {
			Player player = optPlayer.get();
			playerRepo.delete(player);
			return true;
		}
		return false;
	}

	@Override
	public List<PlayerReqDto> search(String str) {
		List<Player> players = playerRepo.searchByNameLike(str);
		List<PlayerReqDto> rs = players.stream().map(p->Mapper.playerDomainToReqDto(p)).collect(Collectors.toList());
		log.info("For given search str :{} the matched record count is:{}", str, rs.size());
		return rs;
	}
	

}
