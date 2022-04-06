package com.careerit.sl.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerit.sl.domain.Team;

public interface TeamRepo extends JpaRepository<Team,Long> {
	

}
