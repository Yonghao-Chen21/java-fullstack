package com.careerit.sl.dto;
//used in loading data from JSON; output for restful API
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
	private double price;

}
