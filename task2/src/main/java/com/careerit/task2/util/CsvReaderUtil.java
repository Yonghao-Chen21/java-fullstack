package com.careerit.task2.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.careerit.task2.domain.Question;

public class CsvReaderUtil {
	private CsvReaderUtil() {

	}

	public static List<Question> getQuestions() {
		List<Question> rs = new ArrayList<>();
		try {
			List<String> tmp = Files.readAllLines(Paths.get("quiz.txt"));
			int count = 0;
			String body = null;
			Map<Integer, String> choiceMap = new HashMap<>();
			int answer;
			for (int i = 0; i < tmp.size(); i++) {
				int n = i % 7;
				switch (n) {
				case 0:
					choiceMap = new HashMap<>();
					break;
				case 1:
					body = tmp.get(i);
					break;
				case 2:
				case 3:
				case 4:
				case 5:
					choiceMap.put(n - 1, tmp.get(i));
					break;
				case 6:
					answer = Integer.parseInt(tmp.get(i).substring(4));
					rs.add(new Question(count + 1, body, choiceMap, answer));
					count++;

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
