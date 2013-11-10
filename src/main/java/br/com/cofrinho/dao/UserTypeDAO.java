package br.com.cofrinho.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cofrinho.model.UserType;

@Repository
public class UserTypeDAO {
	@Autowired
	private SessionFactory sessionFactory;		
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public UserType getUserType(String typeUserCode) {		
		return (UserType) getCurrentSession().get(UserType.class, typeUserCode);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserType> getUserTypes() {
		return getCurrentSession().createQuery("from UserType").list();
	}
}
