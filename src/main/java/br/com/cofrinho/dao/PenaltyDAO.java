package br.com.cofrinho.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cofrinho.model.Penalty;

@Repository
public class PenaltyDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Penalty> getPenaltys() {
		/*		
		Criteria criteria = session.createCriteria(Club.class);
	    criteria.setFetchMode("Team", FetchMode.JOIN);
	    List list = criteria.list();
	    */
		
		return getCurrentSession().createQuery("from Penalty").list();
	}
	
}
