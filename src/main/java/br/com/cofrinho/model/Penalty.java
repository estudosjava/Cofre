package br.com.cofrinho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="multas")
public class Penalty {

	@Id
	@Column(name="cod_multa", nullable = false)
	@GeneratedValue
	private Integer penaltyId;

	@Column(name="cod_tipo_multa", nullable = false)
	private String codTypePenalty;

	@Column(name="valor", nullable = false)
	private String value;

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

	public String getValue(){
		return value;
	}

	public void setValue(String value){
		this.value = value;
	}

}
