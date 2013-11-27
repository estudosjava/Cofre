package br.com.cofrinho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="usuarios_equipes")
public class UsersTeams {

	@ManyToMany
	@Column(name="cod_usuario", nullable= false)	
	private User user;

	@ManyToMany
	@Column(name="cod_equipe", nullable= false)
	private Team team;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
}
