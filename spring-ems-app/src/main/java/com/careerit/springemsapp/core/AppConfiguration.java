package com.careerit.springemsapp.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

	@Bean
	public Greetings greetings() {
		Greetings obj = new Greetings();
		obj.setMessage("Welcome to Spring Boot World");
		return obj;
	}

	@Bean
	public GreetingService greetingService() {
		GreetingService obj = new GreetingService();
		obj.setUserName("User");
		obj.setGreetings(greetings());
		return obj;
	}
}
