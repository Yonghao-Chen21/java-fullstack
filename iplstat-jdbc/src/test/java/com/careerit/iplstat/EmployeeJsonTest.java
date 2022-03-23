package com.careerit.iplstat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
class Employee{
	private int empno;
	private String ename;
	private String email;
}
public class EmployeeJsonTest {
		
		@Test
		public void readJsonData() {
			//jackson databind ObjectMapper()
			ObjectMapper objMapper = new ObjectMapper();
			try {
				// Type name = objMapper.readvalue(fileFromPath,Type.class) it will map the file to the target class
				Employee emp = objMapper.readValue(new File("src/test/resources/emp.json"), Employee.class);
				// write the target to a path.
				objMapper.writeValue(new File("src/test/resources/emp_copy.json"), emp);
				assertEquals("Krish",emp.getEname());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
