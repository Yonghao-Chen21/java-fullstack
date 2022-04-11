package com.careerit.sl.dto;
//in/output for restful API(without list of players)
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamReqDto {
	private Long tid;
	private String city;
	private String home;
	private String coach;
	private String name;
	private String label;
}
