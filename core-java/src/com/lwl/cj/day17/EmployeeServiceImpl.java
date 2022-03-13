package com.lwl.cj.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

	private List<Employee> empList;
	{
		empList = CsvReaderUtil.loadEmpDataFromCsv();
	}

	@Override
	public List<Long> getAllEmpIds() {

		/*
		 * List<Long> idList = new ArrayList<Long>(); if (!empList.isEmpty()) { for
		 * (Employee emp : empList) { idList.add(emp.getEmpno()); } } else {
		 * System.out.println("Employee list is empty"); }
		 */

		List<Long> idList = empList.stream().map(e -> e.getEmpno()).collect(Collectors.toList());
		return idList;
	}

	@Override
	public List<Employee> getEmployee(String dept) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getMaxPaidEmpOfEachDept() {
		
		return null;
	}

	@Override
	public double maxSalaryDiff(String dept1, String dept2) {
		
		return 0;
	}

	@Override
	public List<Employee> getEmpInSortingOrder() {
			return null;
	}

	private List<String> getUniqueDeptName() {
		List<String> list = new ArrayList<String>();
		for (Employee emp : empList) {
			String dname = emp.getDept();
			if (!list.contains(dname)) {
				list.add(dname);
			}
		}
		return list;
	}
	private double maxSalary(String dept) {
		return empList.stream()
				      .filter(e->e.getDept().equalsIgnoreCase(dept))
				      .mapToDouble(e->e.getSalary())
				      .max()
				      .getAsDouble();
		
		
	}

}
