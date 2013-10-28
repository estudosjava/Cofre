package br.com.cofrinho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@Column(name="cod_equipe", nullable= false)
	private Integer teamId;
	
	@Column(nullable= false)
	private String login;
	
	@Column(name="nome", nullable= false)
	private String name;
	
	@Column(name="senha", nullable= false)
	private String password;

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

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
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
	
}
