package br.com.cofrinho.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cofrinho.model.Penalty;
import br.com.cofrinho.model.TypePenalty;
import br.com.cofrinho.model.User;

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
		User user = new User();
		TypePenalty typePenalty = new TypePenalty();		
		user.setUserId(penalty.getUser().getUserId());
		typePenalty.setTypePenaltyId(penalty.getTypePenalty().getTypePenaltyId());		
		Penalty penaltyToUpdate = getPenalty(penalty.getPenaltyId());				
		penaltyToUpdate.setTypePenalty(typePenalty);
		penaltyToUpdate.setExpirationDate(penalty.getExpirationDate());
		penaltyToUpdate.setUser(user);							
		return penaltyToUpdate;
	}
	
	public void updatePenalty(Penalty penalty) {		
		getCurrentSession().update(fillPenalty(penalty));		
	}
	
	@SuppressWarnings("unchecked")
	public List<Penalty> getPenaltys(){
		return getCurrentSession().createQuery("from Penalty").list();
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers(){
		return getCurrentSession().createQuery("from User").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<TypePenalty> getTypePenaltys(){
		return getCurrentSession().createQuery("from TypePenalty").list();
	}
	
	public Penalty getPenalty(int penaltyId){
		return (Penalty) getCurrentSession().get(Penalty.class, penaltyId);
	}

	public void deletePenalty(int penaltyId){
		Penalty penalty = getPenalty(penaltyId);
		if (penalty != null) getCurrentSession().delete(penalty);
	}
	
}
