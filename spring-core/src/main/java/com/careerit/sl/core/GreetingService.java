package com.careerit.sl.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GreetingService {

		private String userName;
		private Greetings greetings;
		
		public void showGreetings() {
			System.out.println(String.format("Hello %s,\n\t %s",userName,greetings.getMessage()));
		}
}
