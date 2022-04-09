package com.careerit.sl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class TeamAmountDTO {

	private String teamCode;
	private String teamName;
	private double amount;
	
	public TeamAmountDTO(String teamCode, String teamName, double amount) {
		this.teamCode = teamCode;
		this.teamName = teamName;
		this.amount = amount;
	}

	public TeamAmountDTO() {
		super();
		
	}
	
	
}
