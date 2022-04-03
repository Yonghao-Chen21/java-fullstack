package com.careerit.springemsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.careerit.springemsapp.core.GreetingService;

@SpringBootApplication
public class SpringEmsAppApplication implements CommandLineRunner {

	@Autowired
	private GreetingService greetingService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringEmsAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			greetingService.showGreetings();	
	}

		
}

