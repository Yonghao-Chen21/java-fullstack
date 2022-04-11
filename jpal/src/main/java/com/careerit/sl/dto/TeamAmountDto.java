package com.careerit.sl.dto;
//used in Ipl service
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamAmountDto {
	private String label;
	private String name;
	private double amount;

}
