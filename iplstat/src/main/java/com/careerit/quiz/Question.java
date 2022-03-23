package com.careerit.quiz;

import java.util.List;

import lombok.Data;

@Data
public class Question {

		private String question;
		private List<String> options;
		private String answer;
}
