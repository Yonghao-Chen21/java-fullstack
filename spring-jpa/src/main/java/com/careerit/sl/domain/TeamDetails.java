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

@Data
@Entity
public class TeamDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String teamCode;
	
	@NotNull
	private String teamName;

	@OneToMany(mappedBy = "teamDetails",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Player> playerList = new ArrayList<Player>();
	
	public void addPlayer(Player player) {
			this.playerList.add(player);
			player.setTeamDetails(this);
	}
		public void removePlayer(Player player) {
			this.playerList.remove(player);
			player.setTeamDetails(null);
	}
}
