package com.careerit.task1.service;

import java.util.List;

import com.careerit.task1.domain.Batch;
import com.careerit.task1.domain.Qualification;
import com.careerit.task1.domain.Student;
import com.careerit.task1.dto.CountDTO;
import com.careerit.task1.dto.StudentDTO;

interface StdService {
	public List<Student> studentsByQualification(Qualification qualification);

	public int getStudentCountByQualification(Qualification qualification);

	public int getPlacedStudentCount();

	public int getNotPlacedStudentCount();

	public CountDTO getPlacedAndNotPlacedCount();

	public List<Student> search(String str);

	public float successRate(Batch batchName);

	public List<Student> maxScoreStudent();

	public List<String> getStudentNames();
	
	public List<StudentDTO> getStudentDTOs();

}
