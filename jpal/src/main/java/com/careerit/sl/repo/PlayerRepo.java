package com.careerit.sl.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careerit.sl.domain.Player;

public interface PlayerRepo extends JpaRepository<Player,Long> {
	public List<Player> findAllByTeamCode(String teamCode);
	public int countByRoleAndTeamCode(String role,String teamCode);
	public List<Player> findByRoleAndTeamCode(String role,String teamCode);
	public List<Player> findAllByOrderByNameAsc();
	public List<Player> findAllByOrderByPriceAsc();
	public List<Player> findAllByOrderByRoleAsc();
	@Query("SELECT p1 FROM Player p1 WHERE p1.role = :role and p1.price = (select max(p2.price) from Player p2 where p2.role = p1.role)")
	List<Player> findWithMaxPriceAndByRole(@Param("role") String role);

}
