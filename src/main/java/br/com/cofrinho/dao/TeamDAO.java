package br.com.cofrinho.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cofrinho.model.Team;

@Repository
public class TeamDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addTeam(Team team) {
		getCurrentSession().save(team);
	}
	
	private Team fillTeam(Team team) {
		Team teamToUpdate = getTeam(team.getTeamId());
		teamToUpdate.setName(team.getName());
		return teamToUpdate;
	}
	
	public void updateTeam(Team team) {
		getCurrentSession().update(fillTeam(team));	
	}
	
	public Team getTeam(int teamId) {
		return (Team) getCurrentSession().get(Team.class, teamId);
	}

	public void deleteTeam(int teamId) {
		Team team = getTeam(teamId);
		if (team != null) getCurrentSession().delete(team);
	}

	@SuppressWarnings("unchecked")
	public List<Team> getTeams() {
		return getCurrentSession().createQuery("from Team").list();
	}

}
