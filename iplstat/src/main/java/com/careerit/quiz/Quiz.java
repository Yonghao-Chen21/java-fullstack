package com.careerit.quiz;

import java.util.List;

import lombok.Data;

@Data
public class Quiz {
	private String title;
	private List<Question> questions;
}
