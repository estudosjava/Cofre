package br.com.cofrinho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@Column(name="cod_usuario", nullable= false)
	@GeneratedValue	
	private Integer codUsuario;	
	
	@Column(name="cod_tipo_usuario", nullable= false)
	private String codTipoUsuario;
	
	@Column(name="cod_equipe", nullable= false)
	private Integer codEquipe;
	
	@Column(nullable= false)
	private String login;
	
	@Column(nullable= false)
	private String nome;
	
	@Column(nullable= false)
	private String senha;	

	public Integer getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getCodTipoUsuario() {
		return codTipoUsuario;
	}

	public void setCodTipoUsuario(String codTipoUsuario) {
		this.codTipoUsuario = codTipoUsuario;
	}

	public Integer getCodEquipe() {
		return codEquipe;
	}

	public void setCodEquipe(Integer codEquipe) {
		this.codEquipe = codEquipe;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	

}
