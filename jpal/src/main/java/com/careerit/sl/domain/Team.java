package com.careerit.sl.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tid;
	@NotNull
	private String name;
	private String city;
	private String coach;
	private String home;
	@NotNull
	private String label;
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Player> players = new ArrayList<>();

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public void addPlayers(List<Player> players) {
		this.players.addAll(players);
	}

	public void removePlayer(Player player) {
		this.players.remove(player);
	}

}
