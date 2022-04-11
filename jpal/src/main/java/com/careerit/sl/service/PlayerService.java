package com.careerit.sl.service;

import java.util.List;

import com.careerit.sl.dto.PlayerReqDto;

public interface PlayerService {
	public PlayerReqDto addPlayer(PlayerReqDto player);
	public PlayerReqDto getPlayer(Long pid);
	public List<PlayerReqDto> getPlayers();
	public PlayerReqDto updatePlayer(PlayerReqDto player);
	public boolean removePlayer(Long pid);
	public List<PlayerReqDto> search(String str);

}
