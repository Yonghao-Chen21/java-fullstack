package com.lwl.cj.day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListAssignment {

	public boolean isSubSet(List<Integer> list1, List<Integer> list2) {
		boolean rs = true;
		for (Integer ele : list1) {
			if (!list2.contains(ele)) {
				rs = false;
				break;
			}
		}
		return rs;
	}

	public List<Integer> getElements(List<Integer> list, Predicate<Integer> p) {
		return list.stream().filter(ele -> p.test(ele)).collect(Collectors.toList());
	}

	public List<Integer> getUniqueElements(List<Integer> list) {
		List<Integer> rs = new ArrayList<>();
		for (Integer ele : list) {
			if (!rs.contains(ele)) {
				rs.add(ele);
			}

		}
		return rs;
	}

	public List<Integer> getCombList(List<Integer> list1, List<Integer> list2) {
		list1.addAll(list2);
		return list1;
	}

	public boolean searchElement(List<Integer> list, Integer key) {
		return list.contains(key);
	}

	// Desc | ASC
	public List<Integer> sort(List<Integer> list, String order) {
		if(order.equals("asc")) {
			Collections.sort(list);
			return list;
		}else if(order.equals("desc")) {
			Collections.sort(list,Collections.reverseOrder());
			return list;
		}

		return null;
	}

	public static void main(String[] args) {
		ListAssignment obj = new ListAssignment();
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(4);
		System.out.println(obj.isSubSet(list1, list2));
		System.out.println(obj.getElements(list1, ele -> ele > 1));
		System.out.println(obj.getUniqueElements(list2));
		System.out.println(obj.getCombList(list1, list2));
		System.out.println(obj.searchElement(list1, 2));
		System.out.println(obj.sort(list2,"desc"));
		
		
	}
}
