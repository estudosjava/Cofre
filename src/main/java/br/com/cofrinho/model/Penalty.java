package br.com.cofrinho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
    @JoinColumn(name="cod_usuario")
    private User user;
	
	

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

	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}

}
