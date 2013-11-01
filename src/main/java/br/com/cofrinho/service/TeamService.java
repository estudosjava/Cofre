package br.com.cofrinho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cofrinho.dao.TeamDAO;
import br.com.cofrinho.model.Team;

@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamDAO teamDAO;
	
	public void addTeam(Team team) {
		teamDAO.addTeam(team);		
	}

	public void updateTeam(Team team) {
		teamDAO.updateTeam(team);
	}

	public Team getTeam(int teamId) {
		return teamDAO.getTeam(teamId);
	}

	public void deleteTeam(int teamId) {
		teamDAO.deleteTeam(teamId);
	}

	public List<Team> getTeams() {
		return teamDAO.getTeams();
	}
}
