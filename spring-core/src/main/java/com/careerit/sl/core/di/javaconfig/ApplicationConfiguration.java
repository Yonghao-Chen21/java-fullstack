package com.careerit.sl.core.di.javaconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

		@Bean(name = "bike")
		public Game bikeGame() {
			return new Bike();
		}
		
		@Bean(name = "car")
		public Game  carGame() {
			return new Car();
		}
		@Bean
		public GameService gameService(@Qualifier("bike")Game game) {
			return new GameServiceImpl(game);
		}
}
