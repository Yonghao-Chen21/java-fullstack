package com.careerit.task1.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.careerit.task1.domain.Batch;
import com.careerit.task1.domain.Qualification;
import com.careerit.task1.domain.Student;

public final class CsvReaderUtil {

	private CsvReaderUtil() {

	}

	public static List<Student> getStudents() {
		List<Student> rs = new ArrayList<>();
		try {
			List<String> tmp = Files.readAllLines(Paths.get("coursedata.csv"));
			for (int i = 1; i < tmp.size(); i++) {
				String[] data = tmp.get(i).split(",");
				String name = data[0];
				Batch batch = Batch.valueOf(data[1]);
				boolean completed = data[2].equals("Y") ? true : false;
				boolean placed = data[3].equals("Y") ? true : false;
				Qualification qualification = Qualification.valueOf(data[4].replace(" ","_").replace(".","_"));
				double score = Double.parseDouble(data[5]);
				rs.add(new Student.StudentBuilder()
								  .name(name)
								  .batch(batch)
								  .completed(completed)
								  .placed(placed)
								  .qualification(qualification)
								  .score(score)
								  .build());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rs;

	}

}
