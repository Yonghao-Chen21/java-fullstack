package com.careerit.task2.domain;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Question {
	private int num;
	private String body;
	private Map<Integer, String> choiceMap;
	private int answer;
}
