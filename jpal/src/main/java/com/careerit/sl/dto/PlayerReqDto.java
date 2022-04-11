package com.careerit.sl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerReqDto {
	private Long pid;
	private String name;
	private String role;
	private double price;
	private Long tid;

}
