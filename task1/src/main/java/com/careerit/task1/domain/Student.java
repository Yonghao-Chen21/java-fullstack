package com.careerit.task1.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString

public class Student {
	private String name;
	private Batch batch;
	private boolean completed;
	private boolean placed;
	private Qualification qualification;
	private double score;

	public Student(StudentBuilder builder) {
		this.name = builder.name;
		this.batch = builder.batch;
		this.completed = builder.completed;
		this.placed = builder.placed;
		this.qualification = builder.qualification;
		this.score = builder.score;
	}

	public static class StudentBuilder {
		private String name;
		private Batch batch;
		private boolean completed;
		private boolean placed;
		private Qualification qualification;
		private double score;

		public StudentBuilder name(String name) {
			this.name = name;
			return this;
		}

		public StudentBuilder batch(Batch batch) {
			this.batch = batch;
			return this;
		}

		public StudentBuilder completed(boolean completed) {
			this.completed = completed;
			return this;
		}

		public StudentBuilder placed(boolean placed) {
			this.placed = placed;
			return this;
		}

		public StudentBuilder qualification(Qualification qualification) {
			this.qualification = qualification;
			return this;
		}

		public StudentBuilder score(double score) {
			this.score = score;
			return this;
		}

		public Student build() {
			return new Student(this);
		}
	}

}
