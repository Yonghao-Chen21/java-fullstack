package com.careerit.sl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamRoleCountAmountDto {
	private String name;
	private String role;
	private Long count;
	private double amount;

}
