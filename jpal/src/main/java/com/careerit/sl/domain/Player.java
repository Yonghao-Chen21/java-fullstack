package com.careerit.sl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	private String name;
	private String role;
	private double price;
	private String teamCode;

}
