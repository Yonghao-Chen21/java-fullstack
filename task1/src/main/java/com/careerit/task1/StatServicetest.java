package com.careerit.task1;

import com.careerit.task1.domain.Batch;
import com.careerit.task1.domain.Qualification;
import com.careerit.task1.service.StdServiceImpl;

public class StatServicetest {
	public static void main(String[] args) {
		StdServiceImpl obj = new StdServiceImpl();

		// 1. Get all students whose qualification is (BE/MCA/BSC)
		System.out.println("All students with BCA: ");
		obj.studentsByQualification(Qualification.BCA).stream().forEach(System.out::println);
		// 2. Get count of all the students by qualification
		System.out.println("Count students with BCA: " + obj.getStudentCountByQualification(Qualification.BCA));
		// 3. Get count of students who got placed
		System.out.println("Count students who got placed: " + obj.getPlacedStudentCount());
		// 4. Get count of student who completed course but not placed
		System.out.println("Count students who completed but not placed: " + obj.getNotPlacedStudentCount());
		// 5. Get count of placed and not placed student
		System.out.println("Count students who completed adn who not placed: " + obj.getPlacedAndNotPlacedCount());
		// 6. Search student by the given name
		System.out.println("Students with name BALL: " + obj.search("BALL"));
		// 7. Get average success rate of the given batch
		System.out.println("Success rate in BCJ4 : " + obj.successRate(Batch.BCJ4));
		// 8. Get max percentage scored Student details
		System.out.println("Max score student : ");
		obj.maxScoreStudent().stream().forEach(System.out::println);
		// 9. Get all the student name only
		//obj.getStudentNames().stream().forEach(System.out::println);
		// 10. Get all the student name,qualification,score
		//obj.getStudentDTOs().stream().forEach(System.out::println);
	}

}
