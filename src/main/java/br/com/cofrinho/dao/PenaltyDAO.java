package br.com.cofrinho.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cofrinho.model.Penalty;

@Repository
public class PenaltyDAO{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Penalty> getPenaltys(){
		return getCurrentSession().createQuery("from Penalty").list();
	}

	public Penalty getPenalty(int penaltyId){
		return (Penalty) getCurrentSession().get(Penalty.class, penaltyId);
	}

	public void deletePenalty(int penaltyId){
		Penalty penalty = getPenalty(penaltyId);
		if (penalty != null) getCurrentSession().delete(penalty);
	}
}
