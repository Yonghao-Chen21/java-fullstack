package com.careerit.iplstat.service;

import java.util.List;
import java.util.Map;

import com.careerit.iplstat.domain.Player;
import com.careerit.iplstat.dto.RoleAmountDTO;

public interface IplStatService {

		
			public List<Player> getPlayers(String teamName);
			public List<Player> getPlayers(String teamName,String role);
			public List<Player> getPlayers(String teamName,String role,String country);
			
			public List<Player> getMaxPaidPlayers(String teamName);
			public List<Player> getMaxPaidPlayers(String teamName,String role);
			
			// Get max paid player(s) of the all teams
			public List<Player> getMaxPaidPlayers();
			
			public Map<String,Double> getAmountSpentByEachRole(String teamName);
			
			// Get amount spent by each role of the all teams
			public Map<String,Double> getAmountSpentByEachRole();
			
			public List<Player> getAllPlayersSortByAmount();
			
			public Map<String,List<RoleAmountDTO>> getTeamRoleAmount();
			
			
			
			
}
