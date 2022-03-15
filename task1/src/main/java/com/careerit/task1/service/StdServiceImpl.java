package com.careerit.task1.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.careerit.task1.domain.Student;
import com.careerit.task1.dto.CountDTO;
import com.careerit.task1.dto.StudentDTO;
import com.careerit.task1.util.CsvReaderUtil;

public class StdServiceImpl implements StdService {

	private List<Student> astudents;

	public StdServiceImpl() {
		super();
		this.astudents = CsvReaderUtil.getStudents();
	}

	public Set<String> getUniqueTypes(String type) {
		List<String> all = new ArrayList<>();
		switch (type) {
		case "name":
			all = astudents.stream().map(p -> p.getName()).collect(Collectors.toList());
			break;
		case "batch":
			all = astudents.stream().map(p -> p.getBatch()).collect(Collectors.toList());
			break;
		case "qualification":
			all = astudents.stream().map(p -> p.getQualification()).collect(Collectors.toList());
		}
		Set<String> uniques = new HashSet<>();
		for (String ele : all) {
			uniques.add(ele);
		}
		return uniques;
	}

	public List<Student> getStudents(Predicate<Student> predicate) {
		return astudents.stream().filter(s -> predicate.test(s)).collect(Collectors.toList());
	}

	@Override
	public List<Student> studentsByQualification(String qualification) {
		// Get all students whose qualification is (BE/MCA/BSC)
		return getStudents(s -> s.getQualification().equals(qualification));
	}

	@Override
	public int getStudentCountByQualification(String qualification) {
		// Get count of all the students by qualification
		return studentsByQualification(qualification).size();
	}

	@Override
	public int getPlacedStudentCount() {
		// Get count of students who got placed
		return getStudents(s -> s.isPlaced()).size();
	}

	@Override
	public int getNotPlacedStudentCount() {
		// Get count of student who completed course but not placed
		return getStudents(s -> s.isCompleted() && !s.isPlaced()).size();
	}

	@Override
	public CountDTO getPlacedAndNotPlacedCount() {
		// Get count of placed and not placed student
		int n = getPlacedStudentCount();
		return new CountDTO(n, astudents.size() - n);
	}

	@Override
	public List<Student> search(String str) {
		// Search student by the given name
		return getStudents(s -> s.getName().equals(str));
	}

	@Override
	public float successRate(String batchName) {
		// Get average success rate of the given batch
		List<Student> students = getStudents(s -> s.getBatch().equals(batchName));
		List<Student> successStudents = getStudents(s -> s.getBatch().equals(batchName) && s.getScore() >= 60);
		return (float) successStudents.size() / students.size() ;
	}

	@Override
	public List<Student> maxScoreStudent() {
		// Get max percentage scored Student details
		double maxScore = astudents.stream().mapToDouble(s -> s.getScore()).max().getAsDouble();
		return getStudents(s -> s.getScore() == maxScore);
	}

	@Override
	public List<String> getStudentNames() {
		// Get all the student name only
		return astudents.stream().map(s -> s.getName()).collect(Collectors.toList());
	}

	@Override
	public List<StudentDTO> getStudentDTOs() {
		// Get all the student name,qualification,score
		return astudents.stream().map(s -> new StudentDTO(s.getName(), s.getQualification(), s.getScore()))
				.collect(Collectors.toList());
	}

}
