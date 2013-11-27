package br.com.cofrinho.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cofrinho.model.Team;
import br.com.cofrinho.model.User;
import br.com.cofrinho.model.UserType;

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
		Team team = new Team();
		UserType userType = new UserType();				
		team.setTeamId(user.getTeam().getTeamId());		
		userType.setUserTypeCode(user.getUserType().getUserTypeCode());				
		User userToUpdate = getUser(user.getUserId());				
		userToUpdate.setUserType(userType);
		userToUpdate.setTeam(team);		
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
	
	@SuppressWarnings("unchecked")
	public List<Team> getTeams() {
		return getCurrentSession().createQuery("from Team").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserType> getUserTypes() {
		return getCurrentSession().createQuery("from UserType").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> checkUser(User user){		
		Query query = getCurrentSession().createQuery("from User where login = :login and password = :password");
		query.setParameter("login", user.getLogin());
		query.setParameter("password", user.getPassword());
		List<User> list = query.list();
		return list;
	}
	
}
