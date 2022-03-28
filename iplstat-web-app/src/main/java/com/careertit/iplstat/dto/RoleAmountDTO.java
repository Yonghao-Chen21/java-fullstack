package com.careertit.iplstat.dto;

import com.careertit.iplstat.domain.PlayerRole;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleAmountDTO {

		private PlayerRole role;
		private Double amount;
}
