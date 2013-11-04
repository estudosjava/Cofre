package br.com.cofrinho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="multas")
public class Penalty {

	@Id
	@Column(name="cod_multa", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer penaltyId;

	@Column(name="cod_tipo_multa", nullable = false)
	private String codTypePenalty;

	@Column(name="cod_usuario", nullable = false)
	private String codUser;

	public Integer getPenaltyId(){
		return penaltyId;
	}

	public void setPenaltyId(Integer penaltyId){
		this.penaltyId = penaltyId;
	}

	public String getCodTypePenalty(){
		return codTypePenalty;
	}

	public void setCodTypePenalty(String codTypePenalty){
		this.codTypePenalty = codTypePenalty;
	}

	public String getCodUser(){
		return codUser;
	}

	public void setCodUser(String codUser){
		this.codUser = codUser;
	}

}
