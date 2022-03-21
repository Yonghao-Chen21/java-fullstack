package com.lwl.cj.day18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Student {

	long id;
	String name;
	int score;

	public Student(long id, String name, int score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
	}

	@Override
	public int hashCode() {
		System.out.println("HashCode method is invoked");
		return Objects.hash(id, name, score);
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Equals method is invoked" + obj);
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return id == other.id && Objects.equals(name, other.name) && score == other.score;
	}

}

public class SetManager {

	public static void main(String[] args) {

		Set<Integer> set = new LinkedHashSet<Integer>();

		set.add(1003);
		set.add(1004);
		set.add(1003);
		set.add(1001);
		set.add(1001);
		set.add(1002);
		set.add(1003);
		set.add(1004);
		set.add(1003);
		set.add(null);
		set.add(null);

		set.forEach(System.out::println);
//					for(Integer i:set) {
//						System.out.println(i);
//					}

		Set<Student> set1 = new HashSet<Student>();

		set1.add(new Student(1001, "Krish", 9));
		set1.add(new Student(1002, "Manoj", 9));
		set1.add(new Student(1001, "Krish", 9));
		set1.add(new Student(1002, "Manoj", 9));
		set1.add(new Student(1003, "Sai", 7));

		set1.stream().sorted((s1, s2) -> s1.name.compareTo(s2.name));
		System.out.println(set1);
		System.out.println(set1.size());

		List<String> cs = Arrays.asList("PKM", "CSV", "ALN", "GLN");
		List<String> is = Arrays.asList("PVN", "CSV", "ALN", "GLN", "ABC", "XYZ");
		List<String> ec = Arrays.asList("KVR", "CSV", "GVR", "GLN", "ALN", "DON", "BON", "KON");
		List<List<String>> listOfLists = Arrays.asList(cs, is, ec);

		// Get people who are working all three departments

		List<String> shortList = cs.size() < is.size() && cs.size() < ec.size() ? cs : is.size() < ec.size() ? is : ec;
		System.out.println(shortList);
		Set<String> uset = new HashSet<String>();
		for (String name : shortList) {
			boolean flag = true;
			for (List<String> list : listOfLists) {
				if (list != shortList && !list.contains(name)) {
					flag = false;
					break;
				}

			}
			if (flag) {
				uset.add(name);
			}

		}
		System.out.println(uset);

		Set<String> unames = new HashSet<String>();
		unames.addAll(is);
		unames.addAll(ec);
		unames.addAll(cs);
		uset = new HashSet<String>();
		for (String name : unames) {
			if (is.contains(name) && cs.contains(name) && ec.contains(name)) {
				uset.add(name);
			}
		}

	}
}
