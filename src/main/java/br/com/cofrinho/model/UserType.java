package br.com.cofrinho.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipos_usuario")
public class UserType {
	@Id	
	@Column(name="cod_tipo_usuario", nullable= false)	
	private String userTypeCode;
	
	@Column(name="descricao", nullable= false)
	private String description;

	@OneToMany(mappedBy="userType")
    private Set<User> users;	

	public String getUserTypeCode() {
		return userTypeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setUserTypeCode(String userTypeCode) {
		this.userTypeCode = userTypeCode;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}	
		
}
