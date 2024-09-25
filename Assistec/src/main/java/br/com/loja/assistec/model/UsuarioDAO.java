package br.com.loja.assistec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.loja.assistec.dal.ModuloConexao;

public class UsuarioDAO {

	private Connection conexao = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	public UsuarioDAO() {
		conexao = ModuloConexao.conector();
	}
	
	public Connection getConexao() {
		return this.conexao;
	}

	public String autenticar(String login, String senha) {
		String sql = "SELECT * FROM usuarios WHERE login=? AND senha=?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, login);
			pst.setString(2, senha);

			rs = pst.executeQuery();

			if (rs.next()) {
				String perfil = rs.getString("perfil");
				return perfil;
			} else {
				return null;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		} finally {
			try {
				this.conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
