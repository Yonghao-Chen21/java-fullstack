package com.careerit.sl.core.di.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.careerit.sl.core.javaconfig"})
public class MainApplication {

		public static void main(String[] args) {
			
			ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
			GameService gameService = context.getBean(GameService.class); 
			gameService.playGame();
			
		}
		
		
}
