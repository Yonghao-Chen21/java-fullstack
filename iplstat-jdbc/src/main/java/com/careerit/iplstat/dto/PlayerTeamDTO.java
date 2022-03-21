package com.careerit.iplstat.dto;

import com.careerit.iplstat.domain.PlayerRole;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlayerTeamDTO {

		private String name;
		private PlayerRole role;
		private String teamCode;
		private String teamName;
		private double price;
}
