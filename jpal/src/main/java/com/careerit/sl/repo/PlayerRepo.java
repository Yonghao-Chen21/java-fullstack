package com.careerit.sl.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careerit.sl.domain.Player;
import com.careerit.sl.domain.Team;
import com.careerit.sl.dto.PlayerWithTeamDetailsDto;
import com.careerit.sl.dto.RoleCountDto;

public interface PlayerRepo extends JpaRepository<Player,Long> {
	
	public List<Player> findByTeam(Team team);
	
	public List<Player> findByTeamLabel(String label);
	
	public int countByRoleAndTeamLabel(String role,String label);
	
	@Query(value = "select new com.careerit.sl.dto.RoleCountDto(p.role,count(p.id)) from Player p where p.role = :role")
	public List<RoleCountDto> getCountByRole(@Param("role") String role);
	
	public List<Player> findByRoleAndTeamLabel(String role,String label);
	
	public List<Player> findAllByOrderByNameAsc();
	
	public List<Player> findAllByOrderByPriceAsc();
	
	public List<Player> findAllByOrderByRoleAsc();
	
	@Query("SELECT p1 FROM Player p1 WHERE p1.role = :role and p1.price = (select max(p2.price) from Player p2 where p2.role = p1.role)")
	public List<Player> findWithMaxPriceAndByRole(@Param("role") String role);
	
	@Query("SELECT p FROM Player p WHERE p.name LIKE %:str%")
	public List<Player> searchByNameLike(@Param("str") String str);
	
	@Query(value = "select new com.careerit.sl.dto.PlayerWithTeamDetailsDto(p.id,p.name,p.role,p.price,t.label,t.city,t.coach,t.home) from Player p inner join Team t on p.team.id = t.id order by p.price desc")
	public List<PlayerWithTeamDetailsDto> getPlayerWtihTeamDetails();
	

}
