package com.careerit.sl.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerit.sl.domain.Player;

public interface PlayerRepo extends JpaRepository<Player, Long> {

	
		
}
