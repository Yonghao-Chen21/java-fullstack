package com.careerit.sl.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.careerit.sl.domain.TeamDetails;
import com.careerit.sl.dto.TeamRoleAmountDTO;
import com.careerit.sl.dto.RoleAmountDto;
import com.careerit.sl.dto.TeamAmountDTO;

public interface TeamDetailsRepo extends JpaRepository<TeamDetails, Long> {

	@Query(value = "select new com.careerit.sl.dto.TeamAmountDTO(t.teamCode,t.teamName,sum(p.price)) from TeamDetails t  inner join Player p on p.teamDetails.id=t.id group by t.id")
	public List<TeamAmountDTO> getTeamAmountDetails();

	@Query(value = "select new com.careerit.sl.dto.TeamRoleAmountDTO(t.teamCode,p.role,sum(p.price)) from Player p inner join TeamDetails t on p.teamDetails.id=t.id group by p.role,p.teamDetails.teamCode order by p.teamDetails.teamCode,p.role ")
	public List<TeamRoleAmountDTO> getRoleAmountEachTeamDetails();
	
	@Query(value = "select new com.careerit.sl.dto.RoleAmountDto(p.role,sum(p.price)) from Player p group by p.role")
	public List<RoleAmountDto> getRoleAmountDetails();
}
