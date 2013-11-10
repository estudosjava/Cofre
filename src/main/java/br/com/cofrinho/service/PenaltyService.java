package br.com.cofrinho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cofrinho.dao.PenaltyDAO;
import br.com.cofrinho.model.Penalty;
import br.com.cofrinho.model.TypePenalty;
import br.com.cofrinho.model.User;

@Service
@Transactional
public class PenaltyService{

	@Autowired
	private PenaltyDAO penaltyDAO;

	public void addPenalty(Penalty penalty) {
		penaltyDAO.addPenalty(penalty);		
	}

	public void updatePenalty(Penalty penalty) {
		penaltyDAO.updatePenalty(penalty);
	}
	
	public Penalty getPenalty(int penaltyId) {
		return penaltyDAO.getPenalty(penaltyId);
	}
	
	public List<Penalty> getPenaltys(){
		return penaltyDAO.getPenaltys();
	}

	public List<User> getUsers(){
		return penaltyDAO.getUsers();
	}
	
	public List<TypePenalty> getTypePenaltys(){
		return penaltyDAO.getTypePenaltys();
	}
	public void deletePenalty(int penaltyId){
		penaltyDAO.deletePenalty(penaltyId);
	}
			
}
