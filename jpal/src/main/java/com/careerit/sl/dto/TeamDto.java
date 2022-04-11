package com.careerit.sl.dto;
//used in loading data from JSON file; 
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
	private String city;
	private String home;
	private String coach;
	private String name;
	private String label;
	private List<PlayerDto> players;

}
