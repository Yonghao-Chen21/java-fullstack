package com.careerit.sl.dto;
//used in Ipl service
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamAmountByRoleDto {
	private String label;
	private String role;
	private double amount;

}
