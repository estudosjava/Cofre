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

	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void addPenalty(Penalty penalty) {
		getCurrentSession().save(penalty);
	}
	
	private Penalty fillPenalty(Penalty penalty) {
		Penalty penaltyToUpdate = getPenalty(penalty.getPenaltyId());				
		penaltyToUpdate.getTypePenalty().setTypePenaltyId(penalty.getPenaltyId());
		penaltyToUpdate.setExpirationDate(penalty.getExpirationDate());
		penaltyToUpdate.getUser().setUserId(penalty.getUser().getUserId());							
		return penaltyToUpdate;
	}
	
	public void updatePenalty(Penalty penalty) {		
		getCurrentSession().update(fillPenalty(penalty));		
	}
	
	@SuppressWarnings("unchecked")
	public List<Penalty> getPenaltys(){
		return getCurrentSession().createQuery("from Penalty").list();
	}

//	public List<User> getUsers(){
//		return getCurrentSession().createQuery("from Users").list();
//	}
	
	public Penalty getPenalty(int penaltyId){
		return (Penalty) getCurrentSession().get(Penalty.class, penaltyId);
	}

	public void deletePenalty(int penaltyId){
		Penalty penalty = getPenalty(penaltyId);
		if (penalty != null) getCurrentSession().delete(penalty);
	}
	
}
