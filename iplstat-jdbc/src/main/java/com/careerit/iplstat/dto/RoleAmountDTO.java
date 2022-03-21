package com.careerit.iplstat.dto;

import com.careerit.iplstat.domain.PlayerRole;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleAmountDTO {

		private PlayerRole role;
		private Double amount;
}
