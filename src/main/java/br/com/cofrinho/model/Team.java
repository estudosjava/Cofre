package br.com.cofrinho.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipes")
public class Team {
	
	@Id
	@Column(name="cod_equipe", nullable= false)
	@GeneratedValue	
	private Integer teamId;
	
	@Column(name="Nome", nullable= false)
	private String name;
	
	/*
	@OneToMany(mappedBy="team")
    private Set<User> users;
	*/
	
	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	*/
	
	
	
}
