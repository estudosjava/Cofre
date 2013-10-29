package br.com.cofrinho.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cofrinho.model.Equipe;

@Repository
public class EquipeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addEquipe(Equipe equipe) {
		getCurrentSession().save(equipe);
	}
	
	public void updateEquipe(Equipe equipe) {
		Equipe equipeToUpdate = getEquipe(equipe.getCodEquipe());				
		equipeToUpdate.setNome(equipe.getNome());
				
		getCurrentSession().update(equipeToUpdate);		
	}
	
	public Equipe getEquipe(int codEquipe) {
		Equipe equipe = (Equipe) getCurrentSession().get(Equipe.class, codEquipe);
		return equipe;
	}

	public void deleteEquipe(int codEquipe) {
		Equipe equipe = getEquipe(codEquipe);
		if (equipe != null)
			getCurrentSession().delete(equipe);
	}

	@SuppressWarnings("unchecked")
	public List<Equipe> getEquipes() {
		return getCurrentSession().createQuery("from Equipe").list();
	}

}
