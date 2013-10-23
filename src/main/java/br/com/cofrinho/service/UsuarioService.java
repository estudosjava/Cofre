package br.com.cofrinho.service;

import java.util.List;

import br.com.cofrinho.model.Usuario;

public interface UsuarioService {
	public void addUsuario(Usuario usuario);
	public void updateUsuario(Usuario usuario);
	public Usuario getUsuario(int codUsuario);
	public void deleteUsuario(int codUsuario);
	public List<Usuario> getUsuarios();
}
