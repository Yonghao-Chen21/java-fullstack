package com.careerit.sl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.careerit.sl.service.IplStatServiceImpl;
import com.careerit.sl.util.JsonLoader;

@SpringBootApplication
public class JpalApplication implements CommandLineRunner {
	
	private JsonLoader loader;
	
	private IplStatServiceImpl service;
	
	@Autowired
	public JpalApplication(final IplStatServiceImpl service, final JsonLoader loader ) {
		this.service =service;
		this.loader = loader;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(JpalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//loader.loadToMysql();
	}



}
