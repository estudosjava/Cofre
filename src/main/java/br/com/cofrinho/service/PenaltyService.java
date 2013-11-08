package br.com.cofrinho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cofrinho.dao.PenaltyDAO;
import br.com.cofrinho.model.Penalty;

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

	public void deletePenalty(int penaltyId){
		penaltyDAO.deletePenalty(penaltyId);
	}
			
}
