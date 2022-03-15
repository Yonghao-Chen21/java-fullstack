package com.careerit.task2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.careerit.task2.domain.Question;
import com.careerit.task2.dto.ResultDTO;
import com.careerit.task2.util.CsvReaderUtil;

public class QuestionServiceImpl implements QuestionService {
	private List<Question> questions;
	private List<Integer> answers;

	public QuestionServiceImpl() {
		super();
		this.questions = CsvReaderUtil.getQuestions();
	}

	public void startQuiz() {
		List<Integer> rs = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		System.out.println("Quiz Starts");
		for (Question question : questions) {
			System.out.println("Question #" + question.getNum());
			System.out.println(question.getBody());
			question.getChoiceMap().entrySet()
					.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
			System.out.println("Your answer: ");
			rs.add(input.nextInt());
		}
		input.close();
		answers = rs;
	}

	@Override
	public int countCorrect() {
		int rs = 0;
		for (int i = 0; i < answers.size(); i++) {
			rs += (answers.get(i) == questions.get(i).getAnswer()) ? 1 : 0;
		}
		return rs;
	}

	@Override
	public int countWrong() {
		return answers.size() - countCorrect();
	}

	@Override
	public float rate() {
		return (float) countCorrect() / answers.size();
	}

	@Override
	public List<ResultDTO> result() {
		// TODO Auto-generated method stub
		return questions.stream().map(q->new ResultDTO(q.getNum(),q.getAnswer())).collect(Collectors.toList());
	}

}
