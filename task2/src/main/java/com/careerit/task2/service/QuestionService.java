package com.careerit.task2.service;

import java.util.List;

import com.careerit.task2.dto.ResultDTO;

interface QuestionService {
	int countCorrect();
	int countWrong();
	float rate();
	List<ResultDTO> result();
	
}
