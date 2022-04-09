package com.careerit.sl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamRoleAmountDTO {

		private String teamCode;
		private String role;
		private double amount;
}
