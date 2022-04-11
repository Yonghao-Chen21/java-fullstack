package com.careerit.sl.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careerit.sl.domain.Team;
import com.careerit.sl.dto.FeaturedAmountByLabelDto;
import com.careerit.sl.dto.RoleAmountDto;
import com.careerit.sl.dto.TeamAmountByRoleDto;
import com.careerit.sl.dto.TeamAmountDto;
import com.careerit.sl.dto.TeamRoleCountAmountDto;

public interface TeamRepo extends JpaRepository<Team,Long> {
	public Team findByLabel(String label);
	
	@Query("SELECT t FROM Team t WHERE t.name LIKE %:str%")
	public List<Team> searchByNameLike(@Param("str") String str);
	
	//List<team amount>
	@Query(value = "select new com.careerit.sl.dto.TeamAmountDto(t.label,t.name,sum(p.price)) from Team t inner join Player p on p.team.id = t.id group by t.id")
	public List<TeamAmountDto> getAmountSpentByTeams();
	
	//List<team role amount>
	@Query(value = "select new com.careerit.sl.dto.TeamAmountByRoleDto(t.label,p.role,sum(p.price)) from Player p inner join Team t on p.team.id=t.id group by p.role,t.label order by t.label,p.role")
	public List<TeamAmountByRoleDto> getAmountSpentPerTeamRoles();
	
	//List<role amount>
	@Query(value = "select new com.careerit.sl.dto.RoleAmountDto(p.role,sum(p.price)) from Player p group by p.role")
	public List<RoleAmountDto> getAmountSpentByRoles();
	
	//List<teamName role count amount>
	@Query(value = "select new com.careerit.sl.dto.TeamRoleCountAmountDto(t.label,p.role,count(1),sum(p.price)) from Player p inner join Team t on p.team.id=t.id where t.label = :label group by p.role order by t.label,p.role")
	public List<TeamRoleCountAmountDto> getTeamRoleCountAmountSpentByRoles(@Param("label") String label);

	//max_amount avg_amount min_amount
	@Query(value = "select new com.careerit.sl.dto.FeaturedAmountByLabelDto(t.label,min(p.price),avg(p.price),max(p.price)) from Player p inner join Team t on p.team.id=t.id where t.label = :label")
	public List<FeaturedAmountByLabelDto> getFeaturedAmountByLabelDto(@Param("label") String label);
	
	

}
