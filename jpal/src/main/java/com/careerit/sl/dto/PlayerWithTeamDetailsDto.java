package com.careerit.sl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerWithTeamDetailsDto {
	private Long pid;
	private String name;
	private String role;
	private double price;
	private String label;
	private String city;
	private String coach;
	private String home;
	

}
