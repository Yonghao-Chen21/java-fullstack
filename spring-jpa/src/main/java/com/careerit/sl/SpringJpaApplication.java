package com.careerit.sl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.careerit.sl.domain.Player;
import com.careerit.sl.domain.TeamDetails;
import com.careerit.sl.dto.PlayerDto;
import com.careerit.sl.dto.TeamDto;
import com.careerit.sl.repo.PlayerRepo;
import com.careerit.sl.repo.TeamDetailsRepo;

// Swagger 
// Validation
// Exception handle

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	@Autowired
	private PlayerRepo playerRepo;

	@Autowired
	private TeamDetailsRepo teamDetailsRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		
		/*
		 * List<TeamDto> teamDtolist = getTeams(); List<PlayerDto> playerList =
		 * getPlayers();
		 * 
		 * for (TeamDto obj : teamDtolist) { System.out.println(obj.getTeamCode() + " "
		 * + playerList.get(0).getTeamCode()); List<PlayerDto> players =
		 * playerList.stream().filter(p -> p.getTeamCode().equals(obj.getTeamCode()))
		 * .collect(Collectors.toList()); System.out.println(players.size());
		 * TeamDetails teamDetails = new TeamDetails();
		 * teamDetails.setTeamCode(obj.getTeamCode());
		 * teamDetails.setTeamName(obj.getTeamName()); List<Player> plist =
		 * players.stream().map(p -> convertPlayer(p)).collect(Collectors.toList()); for
		 * (Player p : plist) { teamDetails.addPlayer(p); }
		 * teamDetailsRepo.save(teamDetails);
		 * 
		 * }
		 */

	}
	private Player convertPlayer(PlayerDto p) {
		return Player.builder().name(p.getName()).role(p.getRole()).price(p.getPrice()).country(p.getCountry()).build();
	}

	private List<PlayerDto> getPlayers() {

		List<PlayerDto> playerList = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(Paths.get(getClass().getResource("/ipl_player_data.csv").toURI()));
			playerList = lines.stream().skip(1).map(line -> convertToPlayer(line)).collect(Collectors.toList());
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return playerList;
	}

	private PlayerDto convertToPlayer(String line) {

		String[] arr = line.split(",");
		String name = arr[0];
		String role = arr[1];
		double price = Double.parseDouble(arr[2]);
		String country = arr[3];
		String teamCode = arr[4];
		PlayerDto player = PlayerDto.builder().name(name).role(role).price(price).teamCode(teamCode).country(country)
				.build();
		return player;
	}

	private List<TeamDto> getTeams() {

		List<TeamDto> teamList = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(Paths.get(getClass().getResource("/team.csv").toURI()));
			teamList = lines.stream().skip(1).map(line -> convertToTeam(line)).collect(Collectors.toList());
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return teamList;
	}

	private TeamDto convertToTeam(String line) {

		String[] arr = line.split(",");
		String teamCode = arr[0];
		String teamName = arr[1];

		TeamDto team = TeamDto.builder().teamCode(teamCode).teamName(teamName).build();
		return team;
	}

}
