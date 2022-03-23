package com.careerit.quiz;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class QuizService {
	public Quiz quiz;
	public String[] answers;
	public List<Question> list;
	public List<String> bd = Arrays.asList("A", "B", "C", "D");

	public void startQuiz() {
		System.out.println("Please wait... You quiz will start soon");
		try {
			Thread.sleep(200);
			quiz = loadYamlData();
			list = quiz.getQuestions();
			answers = new String[list.size()];
			System.out.println("Quiz : " + quiz.getTitle());
			int qnum = 1;
			Scanner sc = new Scanner(System.in);
			for (Question q : list) {
				System.out.println();
				System.out.println(qnum + ". " + q.getQuestion());
				System.out.println();
				List<String> options = q.getOptions();
				int onum = 0;
				for (String opt : options) {
					System.out.println(bd.get(onum) + ". " + opt);
					onum++;

				}
				System.out.println("Enter your answer :");
				String ans = sc.next();
				while (!bd.contains(ans)) {
					System.out.println("Wrong put, enter your answer again: ");
					ans = sc.next();
				}
				answers[qnum - 1] = ans;
				qnum++;
			}
			sc.close();
			System.out.println("You have completed all questions...");
			System.out.println(answers.length);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void showResult() {
		for (int i = 0; i < answers.length; i++) {
			List<String> options = list.get(i).getOptions();
			String ranswer = list.get(i).getAnswer();
			System.out.println(
					"Q#" + (i + 1) + ". Your answer: " + answers[i] + ". " + options.get(bd.indexOf(answers[i]))
							+ ". Right anwer: " + bd.get(options.indexOf(ranswer)) + ". " + ranswer);
		}
	}

	private Quiz loadQuiz() {
		ObjectMapper obj = new ObjectMapper(); // ObjectMapper takes json by default
		Quiz quiz = null;
		try {
			quiz = obj.readValue(this.getClass().getResourceAsStream("/quiz.json"), Quiz.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return quiz;
	}

	private Quiz loadYamlData() {
		ObjectMapper obj = new ObjectMapper(new YAMLFactory()); // need a YAMLFactory object for yaml file.
		Quiz quiz = null;
		try {
			quiz = obj.readValue(this.getClass().getResourceAsStream("/quiz.yaml"), Quiz.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return quiz;
	}
}
