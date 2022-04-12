package com.careerit.sl.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.sl.dto.PlayerReqDto;
import com.careerit.sl.service.PlayerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/player")
@Slf4j
public class PlayerController {
	
private PlayerService service;
	
	@Autowired
	PlayerController(final PlayerService service){
		this.service = service;
	}
	
	@PostMapping
	public PlayerReqDto addPlayer(@RequestBody PlayerReqDto p) {
		return service.addPlayer(p);
	}
	
	@GetMapping("/all")
	public List<PlayerReqDto> getPlayers(){
		return service.getPlayers();
	}
	
	@GetMapping("/get/{id}")
	public PlayerReqDto getPlayer(@PathVariable("id") Long id){
		return service.getPlayer(id);
	}

	@PutMapping("/update")
	public PlayerReqDto updateProduct(@RequestBody PlayerReqDto p) {
		return service.updatePlayer(p);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long pid) {
		boolean res = service.removePlayer(pid);
		return res ? "Player is deleted" : "Player is not found for given id";
	}

	@GetMapping("/search")
	public List<PlayerReqDto> search(@RequestParam String str) {
		log.info("Search String is :{}",str);
		return service.search(str);
	}

}
