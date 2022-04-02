package com.careerit.sl.core.di.scopes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.careerit.sl.core.di.scopes")
public class TaskManagerApplication {

		public static void main(String[] args) {
			
			ApplicationContext context = new AnnotationConfigApplicationContext(TaskManagerApplication.class);
			TaskManager obj1 = context.getBean(TaskManager.class);
			TaskManager obj2 = context.getBean(TaskManager.class);
			TaskManager obj3 = context.getBean(TaskManager.class);
			TaskManager obj4 = context.getBean(TaskManager.class);
			
			System.out.println(obj1);
			System.out.println(obj2);
			System.out.println(obj3);
			System.out.println(obj4);
			for(String task:obj1.getCurrentTasks()) {
				System.out.println(task);
			}
		}
}
