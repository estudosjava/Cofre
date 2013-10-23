package br.com.cofrinho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cofrinho.dao.EquipeDAO;
import br.com.cofrinho.model.Equipe;

@Service
@Transactional
public class EquipeServiceImpl implements EquipeService {
	
	@Autowired
	private EquipeDAO equipeDAO;
	
	public void addEquipe(Equipe equipe) {
		equipeDAO.addEquipe(equipe);		
	}

	public void updateEquipe(Equipe equipe) {
		equipeDAO.updateEquipe(equipe);
	}

	public Equipe getEquipe(int codEquipe) {
		return equipeDAO.getEquipe(codEquipe);
	}

	public void deleteEquipe(int codEquipe) {
		equipeDAO.deleteEquipe(codEquipe);
	}

	public List<Equipe> getEquipes() {
		return equipeDAO.getEquipes();
	}

}
