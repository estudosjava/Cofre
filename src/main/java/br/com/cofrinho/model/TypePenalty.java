package br.com.cofrinho.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="tipos_multa")
public class TypePenalty {
	
	@Id
	@Column(name="cod_tipo_multa", nullable= false)
	@GeneratedValue	
	private Integer typePenaltyId;
	
	@Column(name="descricao", nullable= false)
	private String description;
	
	@Column(name="valor", nullable= false)
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal value;

	public Integer getTypePenaltyId() {
		return typePenaltyId;
	}

	public void setTypePenaltyId(Integer typePenaltyId) {
		this.typePenaltyId = typePenaltyId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
