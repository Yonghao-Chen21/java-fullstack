package com.careerit.sl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.careerit.sl.dto.PlayerDTO;
import com.careerit.sl.dto.RoleCountDTO;
import com.careerit.sl.dto.TeamAmountByRoleDTO;
import com.careerit.sl.dto.TeamAmountDTO;
import com.careerit.sl.dto.TeamDTO;
import com.careerit.sl.service.PlayerServiceImpl;

@SpringBootApplication
public class JpalApplication implements CommandLineRunner {
	
	private PlayerServiceImpl service;
	
	@Autowired
	public JpalApplication(final PlayerServiceImpl service) {
		this.service =service;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(JpalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//service.loadToMysql();
		//get labels
		List<String> rs1 = service.getTeamLabels();
		rs1.stream().forEach(p->System.out.println(p));
		//get players by teamCode
		List<PlayerDTO> rs2 = service.getPlayerByTeam("DC");
		rs2.stream().forEach(p->System.out.println(p));
		//get role counts
		List<RoleCountDTO> rs3 = service.getCountByRole("DC");
		rs3.stream().forEach(p->System.out.println(p));
		//get players by role and label
		List<PlayerDTO> rs4 = service.getPlayerByTeamAndRole("DC","Bowler");
		rs4.stream().forEach(p->System.out.println(p));
		//get all teams
		List<TeamDTO> rs5 = service.getAllTeamDetails();
		rs5.stream().forEach(p->System.out.println(p));
		//get all team spent
		List<TeamAmountDTO> rs6 = service.getAmountSpentByTeams();
		rs6.stream().forEach(p->System.out.println(p));
		//get amount spent by role given team
		List<TeamAmountByRoleDTO> rs7 = service.getAmountSpentByTeamAndRole("DC");
		rs7.stream().forEach(p->System.out.println(p));
		//get sorted players by field
		List<PlayerDTO> rs8 = service.getPlayersBySort("price");
		rs8.stream().limit(10).forEach(p->System.out.println(p));
		//get max spent player by role
		Map<String, List<PlayerDTO>> rs9 =service.getMaxPaidPlayersByRole();
		rs9.entrySet().forEach(p->System.out.println(p.getKey() + " : " + p.getValue()));

	}



}
