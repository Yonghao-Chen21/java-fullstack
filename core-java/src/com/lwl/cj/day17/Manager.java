package com.lwl.cj.day17;

final class TaskManager{
	
		private static TaskManager obj;
		private TaskManager() {
		}
		public void showTasks() {
			System.out.println(".......");
		}
		
		public static TaskManager getInstance() {
			if(obj == null)
				obj = new TaskManager();
			
			return obj;
		}
		
}
public class Manager {

		public static void main(String[] args) {
			
				TaskManager obj1 = TaskManager.getInstance();
				TaskManager obj2 = TaskManager.getInstance();
				TaskManager obj3 = TaskManager.getInstance();
				System.out.println(obj1);
				System.out.println(obj2);
				System.out.println(obj3);
		}
}
