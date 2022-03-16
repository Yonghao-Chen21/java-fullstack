package com.lwl.cj.day17;

import java.util.ArrayList;
import java.util.Comparator;
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
		List<Employee> dlist = empList.stream()
									  .filter(e->e.getDept().equals(dept))
									  .collect(Collectors.toList());
		return dlist;
	}

	@Override
	public List<Employee> getMaxPaidEmpOfEachDept() {
		List<String> depts = getUniqueDeptName();
		List<Employee> rs = new ArrayList<>();
		for (String dept : depts) {
			double maxs = maxSalary(dept);
			List<Employee> tmp = empList.stream()
					  					.filter(e->e.getDept().equals(dept)&&e.getSalary()==maxs)
					  					.collect(Collectors.toList());
			rs.addAll(tmp);
//			empList.stream()
//				.filter(e->e.getDept().equals(dept)&&e.getSalary()==maxs)
//				.forEach(e->rs.add(e));
		}
		
		
		return rs;
	}

	@Override
	public double maxSalaryDiff(String dept1, String dept2) {
		double maxs1 = maxSalary(dept1);
		double maxs2 = maxSalary(dept2);
		
		return Math.abs(maxs1-maxs2);
	}

	@Override
	public List<Employee> getEmpInSortingOrder() {
		empList.sort(Comparator.comparing(Employee::getSalary));
			return empList;
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