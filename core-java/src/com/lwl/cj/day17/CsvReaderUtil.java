package com.lwl.cj.day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class CsvReaderUtil {

	private CsvReaderUtil() {

	}

	public static List<Employee> loadEmpDataFromCsv() {
		List<Employee> rs = new ArrayList<>();
		try {
			List<String> tmp = Files.readAllLines(Paths.get("data/emp_data.csv"));
			for (int i = 1; i < tmp.size(); i++) {
				String[] data = tmp.get(i).split(",");
				Long empno = Long.parseLong(data[0]);
				String name = data[1];
				double salary = Double.parseDouble(data[2]);
				String dept = data[3];
				rs.add(new Employee(empno, name, salary, dept));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
