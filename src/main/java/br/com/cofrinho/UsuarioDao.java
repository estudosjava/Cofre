package br.com.cofrinho;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.cofrinho.model.Usuario;

public class UsuarioDao {

	public void conecta() {

		try {
			Connection connection = new ConnectionFactory().getConnection();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Erro na conexao com o banco: " + e);
		}
	}

	public boolean buscaUsuario(Usuario usuario) {

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
