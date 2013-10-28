package br.com.cofrinho.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.com.cofrinho.ConnectionFactory;
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
	
	private User instanceUserDAO (User user) {
		User userToUpdate = getUser(user.getUserId());				
		userToUpdate.setUserTypeId(user.getUserTypeId());
		userToUpdate.setTeamId(user.getTeamId());
		userToUpdate.setLogin(user.getLogin());
		userToUpdate.setName(user.getName());
		userToUpdate.setPassword(user.getPassword());
		
		return userToUpdate;
	}
	
	public void updateUser(User user) {
		User userToUpdate = instanceUserDAO(user);
				
		getCurrentSession().update(userToUpdate);		
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
	
	public boolean checkUser(User user) {

		Connection con = new ConnectionFactory().getConnection();
	
		ResultSet rs;

		int numberOfRecords = 0;
		boolean userExist = false;
	
		String query = "select * from usuarios \n";
		query += "where login = '" + user.getLogin() + "' \n";
		query += "and senha = '" + user.getPassword() + "'";
	
		try {	
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				numberOfRecords++;			
			}
			
			if (numberOfRecords >= 1) {				
				userExist = true;
			}
			
			stmt.close();
			con.close();

		} catch (SQLException sqle) {		
			System.out.println("Erro no select: " + sqle);
		}		
		return userExist;
	}
	
}
