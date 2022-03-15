package com.careerit.task1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
	private String name;
	private String batch;
	private boolean completed;
	private boolean placed;
	private String qualification;
	private double score;

}
