package br.com.cofrinho.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.com.cofrinho.ConnectionFactory;
import br.com.cofrinho.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addUsuario(Usuario usuario) {
		getCurrentSession().save(usuario);
	}

	public void updateUsuario(Usuario usuario) {
		Usuario usuarioToUpdate = getUsuario(usuario.getCodUsuario());				
		usuarioToUpdate.setCodTipoUsuario(usuario.getCodTipoUsuario());
		usuarioToUpdate.setCodEquipe(usuario.getCodEquipe());
		usuarioToUpdate.setLogin(usuario.getLogin());
		usuarioToUpdate.setNome(usuario.getNome());
		usuarioToUpdate.setSenha(usuario.getSenha());
				
		getCurrentSession().update(usuarioToUpdate);		
	}

	public Usuario getUsuario(int codUsuario) {
		Usuario usuario = (Usuario) getCurrentSession().get(Usuario.class, codUsuario);
		return usuario;
	}

	public void deleteUsuario(int codUsuario) {
		Usuario usuario = getUsuario(codUsuario);
		if (usuario != null)
			getCurrentSession().delete(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios() {
		return getCurrentSession().createQuery("from Usuario").list();
	}
	
	public boolean validaUsuario(Usuario usuario) {

		Connection con = new ConnectionFactory().getConnection();

		ResultSet rs;

		int iRegistros = 0;
		boolean cadastrado = false;

		String consulta = "select * from usuarios \n";
		consulta += "where login = '" + usuario.getLogin() + "' \n";
		consulta += "and senha = '" + usuario.getSenha() + "'";
		
		try {

			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(consulta);

			while (rs.next()) {
				iRegistros++;
			}
			
			if (iRegistros >= 1) {
				cadastrado = true;
			}

			stmt.close();
			con.close();

		} catch (SQLException sqle) {
			System.out.println("Erro no select: " + sqle);
		}
		return cadastrado;
	}
	
}
