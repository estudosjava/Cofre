package br.com.cofrinho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cofrinho.dao.UsuarioDAO;
import br.com.cofrinho.model.Usuario;
import br.com.cofrinho.service.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	public void addUsuario(Usuario usuario) {
		usuarioDAO.addUsuario(usuario);		
	}

	public void updateUsuario(Usuario usuario) {
		usuarioDAO.updateUsuario(usuario);
	}

	public Usuario getUsuario(int codUsuario) {
		return usuarioDAO.getUsuario(codUsuario);
	}

	public void deleteUsuario(int codUsuario) {
		usuarioDAO.deleteUsuario(codUsuario);
	}

	public List<Usuario> getUsuarios() {
		return usuarioDAO.getUsuarios();
	}

}
