package com.careertit.iplstat.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
	private int pid;
	private String name;
	private PlayerRole role;
	private double price;
	private String country;
	private String team;
	
	
}
