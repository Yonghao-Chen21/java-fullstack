package com.careerit.iplstat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {

	private String name;
	private String role;
	private double price;
	private String country;
	private String team;


}
