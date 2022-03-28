package com.careertit.iplstat.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TeamStatDto {

	private String teamCode;
	private String teamName;
	private double totalAmount;
	private int playerCount;
	private double avgAmount;
}
