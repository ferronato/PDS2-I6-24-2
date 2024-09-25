package br.com.loja.assistec.controller;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.com.loja.assistec.model.UsuarioDAO;
import br.com.loja.assistec.view.LoginView;

//LoginController implementa a interface IController
public class LoginController implements IController {

	//O controller cria o view e o model para poder acessar os dois
	private LoginView frame;
	private UsuarioDAO usuarioDAO;

	public LoginController() {
		usuarioDAO = new UsuarioDAO();
	}

	// Implementa a interface controller e a view recebe o objeto da classe de
	// visualização
	public void executa(Object view) {
		this.frame = (LoginView) view;
		if (usuarioDAO.getConexao() != null) {
//			System.out.println("Conectado");
//	        frame.getLblStatus().setText("Conectado!");
			frame.getLblStatus()
					.setIcon(new ImageIcon(getClass().getResource("/br/com/loja/assistec/icones/dbok.png")));
		} else {
//			System.out.println("Não conectado");
//			frame.getLblStatus().setText("Desconectado!");
			frame.getLblStatus()
					.setIcon(new ImageIcon(getClass().getResource("/br/com/loja/assistec/icones/dberror.png")));
		}
	}

	//Método que faz a busca dos dados no view
	public void logar() {
		usuarioDAO = new UsuarioDAO();
		String login = frame.getTxtUsuario().getText();
		String senha = new String(frame.getTxtSenha().getPassword());

		if (usuarioDAO.getConexao() != null) {
			String perfil = usuarioDAO.autenticar(login, senha);

			if (perfil != null) {
				JOptionPane.showMessageDialog(null, "Usuário poderá acessar o sistema");
			} else {
				JOptionPane.showMessageDialog(null, "Login ou Senha Inválidos!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Banco de dados não está conectado!");
		}
			
	}

}
