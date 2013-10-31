package br.com.cofrinho.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cofrinho.model.TypePenalty;

@Repository
public class TypePenaltyDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addTypePenalty(TypePenalty typepenalty) {
		getCurrentSession().save(typepenalty);
	}
	
	private TypePenalty instanceTypePenaltyDAO (TypePenalty typepenalty) {
		TypePenalty typepenaltyToUpdate = getTypePenalty(typepenalty.getTypePenaltyId());
		typepenaltyToUpdate.setDescription(typepenalty.getDescription());
		typepenaltyToUpdate.setValue(typepenalty.getValue());
		return typepenaltyToUpdate;
	}
	
	public void updateTypePenalty(TypePenalty typepenalty) {
		TypePenalty typepenaltyToUpdate = instanceTypePenaltyDAO(typepenalty);
		
		getCurrentSession().update(typepenaltyToUpdate);	
	}
	
	public TypePenalty getTypePenalty(int typePenaltyId) {
		TypePenalty typepenalty = (TypePenalty) getCurrentSession().get(TypePenalty.class, typePenaltyId);
		return typepenalty;
	}

	public void deleteTypePenalty(int typePenaltyId) {
		TypePenalty typepenalty = getTypePenalty(typePenaltyId);
		if (typepenalty != null)
			getCurrentSession().delete(typepenalty);
	}

	@SuppressWarnings("unchecked")
	public List<TypePenalty> getTypePenaltys() {
		return getCurrentSession().createQuery("from TypePenalty").list();
	}
}
