package br.com.loja.assistec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO extends GenericDAO {


	public Boolean bancoOnline() {
		Connection valor = getConnection();
		if (valor != null){
			return true;
		} else
			return false;
	}

	// Aqui vai o método autenticar
	public Usuario autenticar(String login, String senha) {
		String sql = "SELECT * FROM usuarios WHERE login=? AND senha=?";
		Usuario usuario = null;
		PreparedStatement pstm;
		try {
			pstm = getConnection().prepareStatement(sql);
			pstm.setString(1, login);
			pstm.setString(2, senha);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();
				usuario.setIduser(rs.getInt("iduser"));
				usuario.setNome(rs.getString("nome"));
				usuario.setFone(rs.getString("fone"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPerfil(rs.getString("perfil"));
			}

			rs.close();
			pstm.close();
			getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Catch LoginDAO");
			e.printStackTrace();
		}

		return usuario;

	}

}
