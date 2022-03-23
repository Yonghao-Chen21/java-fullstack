package com.careerit.iplstat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
class Team {
	private String name;
	private String coach;
	private String city;
	private String home;
	private String label;
	private List<Player> players;
}

@Data
class Player {
	private String name;
	private String role;
	private double price;
}

public class PlayerDataTest {

	@Test
	public void readJsonData() {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			//the json file is an array of teams object. and the team object contains an array of player attribute.
			//so first variable is List<Team> and the target is new TypeReference<List<Team>> instead of Team.class.
			//TypeReference gives a reference of what type of data you want after the parsing is complete
			List<Team> teams = objMapper.readValue(new File("src/test/resources/ipl2020.json"),
					new TypeReference<List<Team>>() {
					});
			assertEquals(8, teams.size());
			//you can see the json data is well parsed, even the list of players were converted into Player obj
			assertEquals("Rohit Sharma (R)", teams.get(0).getPlayers().get(0).getName());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
