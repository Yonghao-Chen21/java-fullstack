package com.lwl.cj.day22;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
// https://jsltech.blogspot.com/2012/05/reflection-api-in-java.html
class MyList<T> {

	private Object[] obj;
	int count = 0;

	public MyList() {
		obj = new Object[3];
	}

	public boolean addAll(MyList<? extends T> ele) {
		
		return true;
	}
	public boolean add(T ele) {
		if(count < obj.length) {
			obj[count++] = ele;
		}else {
			Object[] temp = new Object[count + count/2];
			System.arraycopy(obj, 0, temp, 0, count);
			obj = temp;
			obj[count++] = ele;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		if(index >= 0 && index <  count) {
			return (T)obj[index];
		}
		throw new IndexOutOfBoundsException("index can't -ve number or more than the size "+index+" and size "+count);
	}

	public void showElements() {
		for(int i=0;i<count;i++) {
			System.out.println(obj[i]);
		}
	}

	public boolean remove(int index) {
		//TODO implement remove method
		return false;
	}

	public int size() {
		return count;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

public class ReflectionApiExample {

	public static void main(String[] args) {

		try {
			Class<?> cls = Class.forName("java.lang.String");
			Method[] mArr = cls.getDeclaredMethods();

			for (Method m : mArr) {
				System.out.println(m);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Integer> list = new ArrayList<>();
		list.add(1001);
		list.add(1003);
		list.add(1002);
		list = sort(list);

		List<String> list1 = new ArrayList<>();
		list1.add("1001");
		list1.add("1003");
		list1.add("1002");
		list1 = sort(list1);
		
		MyList<Float> myList = new MyList<>();
		myList.showElements();
	}

	public static <T> List<T> sort(List<T> list) {

		return null;
	}
}
