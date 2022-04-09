package com.careerit.sl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
		
		private String name;
		private String role;
		private String country;
		private double price;
		private String teamCode;
}
