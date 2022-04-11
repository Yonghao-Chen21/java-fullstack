package com.careerit.sl.dto;

//used in Ipl service
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleCountDto {
	private String role;
	private Long count;

}
