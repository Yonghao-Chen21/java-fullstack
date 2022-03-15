package com.careerit.task2;

import com.careerit.task2.service.QuestionServiceImpl;

public class QuizManager {
	public static void main(String[] args) {
		QuestionServiceImpl obj = new QuestionServiceImpl();
		obj.startQuiz();
		System.out.println("Correct count: " + obj.countCorrect());
		System.out.println("Wrong count: " + obj.countWrong());
		System.out.println("Correct rate: " + obj.rate());
		System.out.println("Correct Result :");
		obj.result().stream().forEach(System.out::println);
	}
}
