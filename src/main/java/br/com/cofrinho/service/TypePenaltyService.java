package br.com.cofrinho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cofrinho.dao.TypePenaltyDAO;
import br.com.cofrinho.model.TypePenalty;

@Service
@Transactional
public class TypePenaltyService {

	@Autowired
	private TypePenaltyDAO typePenaltyDAO;
	
	public void addTypePenalty(TypePenalty typepenalty) {
		typePenaltyDAO.addTypePenalty(typepenalty);		
	}

	public void updateTypePenalty(TypePenalty typepenalty) {
		typePenaltyDAO.updateTypePenalty(typepenalty);
	}

	public TypePenalty getTypePenalty(int typePenaltyId) {
		return typePenaltyDAO.getTypePenalty(typePenaltyId);
	}

	public void deleteTypePenalty(int typePenaltyId) {
		typePenaltyDAO.deleteTypePenalty(typePenaltyId);
	}

	public List<TypePenalty> getTypePenaltys() {
		return typePenaltyDAO.getTypePenaltys();
	}

}
