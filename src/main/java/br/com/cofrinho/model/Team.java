package br.com.cofrinho.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	
}
