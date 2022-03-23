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
			List<Team> teams = objMapper.readValue(new File("src/test/resources/ipl2020.json"),
					new TypeReference<List<Team>>() {
					});
			assertEquals(8, teams.size());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
