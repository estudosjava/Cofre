package br.com.cofrinho.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class User {

	@Id
	@Column(name="cod_usuario", nullable= false)
	@GeneratedValue	
	private Integer userId;	
	
	@Column(name="cod_tipo_usuario", nullable= false)
	private String userTypeId;		
	
	@ManyToOne
    @JoinColumn(name="cod_equipe")
    private Team team;
    	
	/*@Column(name="cod_equipe", nullable= false)
	private Integer teamId;*/
	
	@Column(nullable= false)
	private String login;
	
	@Column(name="nome", nullable= false)
	private String name;
	
	@Column(name="senha", nullable= false)
	private String password;
	
	@OneToMany(mappedBy="user")
    private Set<Penalty> penaltys;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Penalty> getPenaltys() {
		return penaltys;
	}

	public void setPenaltys(Set<Penalty> penaltys) {
		this.penaltys = penaltys;
	}

	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	/*public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}*/
	
}
