package br.com.cofrinho.model;

import java.util.Date;

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
	@Column(name="cod_multa", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer penaltyId;

	@ManyToOne
	@JoinColumn(name="cod_tipo_multa")
	private TypePenalty typePenalty;

	@ManyToOne
	@JoinColumn(name="cod_usuario")
	private User user;

	@Column(name="data_vencimento")
	private Date expirationDate;

	public Integer getPenaltyId(){
		return penaltyId;
	}

	public void setPenaltyId(Integer penaltyId){
		this.penaltyId = penaltyId;
	}

	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}

	public TypePenalty getTypePenalty(){
		return typePenalty;
	}

	public void setTypePenalty(TypePenalty typePenalty){
		this.typePenalty = typePenalty;
	}

	public Date getExpirationDate(){
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate){
		this.expirationDate = expirationDate;
	}
}
