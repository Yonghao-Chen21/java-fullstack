package com.careerit.iplstat.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlayerTeamDTO {

		private String name;
		private String role;
		private String teamCode;
		private String teamName;
		private double price;
}
