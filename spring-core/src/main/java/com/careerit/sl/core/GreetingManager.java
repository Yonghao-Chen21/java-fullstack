package com.careerit.sl.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingManager {

	public static void main(String[] args) {

		    ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-core.xml","greetings-spring.xml"});
			
			
			ConnectionDetails connectDetails = context.getBean(ConnectionDetails.class);
			System.out.println(connectDetails);
			
			GreetingService greetingService = context.getBean(GreetingService.class);
			greetingService.showGreetings();
			
	}
}
