package br.com.cofrinho.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipes")
public class Equipe {
	
	@Id
	@Column(name="cod_equipe", nullable= false)
	@GeneratedValue	
	private Integer codEquipe;
	
	@Column(name="Nome", nullable= false)
	private String nome;
	
	public Integer getCodEquipe() {
		return codEquipe;
	}
	
	public void setCodEquipe(Integer codEquipe) {
		this.codEquipe = codEquipe;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
}
