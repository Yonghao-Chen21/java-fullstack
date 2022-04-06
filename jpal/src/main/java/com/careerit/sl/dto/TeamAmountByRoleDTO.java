package com.careerit.sl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamAmountByRoleDTO {
	private String label;
	private String role;
	private double amount;

}
