package com.lwl.cj.day17;

public class EmployeeManager {
	

		public static void main(String[] args) {
			EmployeeServiceImpl obj = new EmployeeServiceImpl();
			System.out.println(obj.getAllEmpIds());
			System.out.println();
			System.out.println(obj.getEmployee("Sales"));
			System.out.println();
			System.out.println(obj.getMaxPaidEmpOfEachDept());
			System.out.println();
			System.out.println(obj.maxSalaryDiff("Sales","Dev"));
			
		}
}
