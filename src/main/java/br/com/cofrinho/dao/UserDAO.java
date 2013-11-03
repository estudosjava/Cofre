package br.com.cofrinho.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cofrinho.model.User;

@Repository
public class UserDAO {
		
	@Autowired
	private SessionFactory sessionFactory;		
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addUser(User user) {
		getCurrentSession().save(user);
	}
	
	private User fillUser(User user) {
		User userToUpdate = getUser(user.getUserId());				
		userToUpdate.setUserTypeId(user.getUserTypeId());
		userToUpdate.setTeamId(user.getTeamId());
		userToUpdate.setLogin(user.getLogin());
		userToUpdate.setName(user.getName());
		userToUpdate.setPassword(user.getPassword());		
		return userToUpdate;
	}
	
	public void updateUser(User user) {		
		getCurrentSession().update(fillUser(user));		
	}

	public User getUser(int userId) {		
		return (User) getCurrentSession().get(User.class, userId);
	}

	public void deleteUser(int userId) {
		User user = getUser(userId);
		if (user != null) getCurrentSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User").list();
	}
	
	@SuppressWarnings("rawtypes")
	public boolean checkUser(User user){		
		List exist = getCurrentSession().createCriteria(User.class).add(Example.create(user)).list();
		if (exist.size() > 0) return true;
		else return false;			

	}
	
}
