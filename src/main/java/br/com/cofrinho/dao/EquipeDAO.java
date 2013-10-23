package br.com.cofrinho.dao;

import java.util.List;

import br.com.cofrinho.model.Equipe;

public interface EquipeDAO {
	
	public void addEquipe(Equipe equipe);
	public void updateEquipe(Equipe equipe);
	public Equipe getEquipe(int codEquipe);
	public void deleteEquipe(int codEquipe);
	public List<Equipe> getEquipes();

}
