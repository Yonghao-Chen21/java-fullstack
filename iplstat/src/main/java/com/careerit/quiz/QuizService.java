package com.careerit.quiz;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class QuizService {

	public void startQuiz() {
		System.out.println("Please wait... You quiz will start soon");
		try {
			Thread.sleep(200);
			Quiz quiz = loadYamlData();
			System.out.println("Quiz : " + quiz.getTitle());
			List<Question> list = quiz.getQuestions();
			int i = 1;
			Scanner sc = new Scanner(System.in);
			for(Question q:list) {
				System.out.println();
				System.out.println(i+". "+q.getQuestion());
				System.out.println();
				List<String> options = q.getOptions();
				int c=1;
				for(String opt:options) {
					System.out.println(opt);
					
				}
				i++;
				System.out.println("Enter your answer :");
				int ch = sc.nextInt();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private Quiz loadQuiz() {
		ObjectMapper obj = new ObjectMapper();
		Quiz quiz = null;
		try {
			quiz = obj.readValue(this.getClass().getResourceAsStream("/quiz.json"), Quiz.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return quiz;
	}
	
	private Quiz loadYamlData() {
		ObjectMapper obj = new ObjectMapper(new YAMLFactory());
		Quiz quiz = null;
		try {
			quiz = obj.readValue(this.getClass().getResourceAsStream("/quiz.yaml"), Quiz.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return quiz;
	}
}
