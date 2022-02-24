package com.lwl.cj.day6;


class Student{
	
		String name;
		int score;
		public Student(String name, int score) {
		
			this.name = name;
			this.score = score;
		}
		public void showInfo() {
			System.out.println("Name :"+name);
			System.out.println("Score :"+score);
		}
		
}

public class ArrayWithReferenceDataType {

		public static void main(String[] args) {
			
				
				Student[] arr = getStudentScores();
				
				for(int i=0;i<arr.length;i++) {
					Student s = arr[i];
					s.showInfo();
				}
				
				int sum = 0;
				for(Student s:arr) {
					sum += s.score;
				}
				float avg = sum / (float)arr.length;
				System.out.println("Sum     :"+sum);
				System.out.println("Count   :"+arr.length);
				System.out.println("Average :"+avg);
				
				
		}

		private static Student[] getStudentScores() {
			Student s1 = new Student("John", 9);
			Student s2 = new Student("Mani", 8);
			Student s3 = new Student("Krish", 7);
			Student s4 = new Student("Charan", 6);
			Student s5 = new Student("Kiran", 8);
			return new Student[] {s1,s2,s3,s4,s5};
			
		}
}
