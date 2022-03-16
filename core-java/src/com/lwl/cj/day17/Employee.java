package com.lwl.cj.day17;

public class Employee {
	
		private Long empno;
		private String name;
		private double salary;
		private String dept;
		
		public Employee(Long empno, String name, double salary, String dept) {
			super();
			this.empno = empno;
			this.name = name;
			this.salary = salary;
			this.dept = dept;
		}
		public Long getEmpno() {
			return empno;
		}
		public void setEmpno(Long empno) {
			this.empno = empno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		@Override
		public String toString() {
			return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + ", dept=" + dept + "]";
		}
		
		
		
}
