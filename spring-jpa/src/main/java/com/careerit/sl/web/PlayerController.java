package com.careerit.sl.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.sl.dto.PlayerDto;

@RestController
@RequestMapping("/player")
public class PlayerController {

		
		@PostMapping
		public PlayerDto addPlayer(@RequestBody PlayerDto playerDto) {
			//Logic
			return null;
			
		}
}
