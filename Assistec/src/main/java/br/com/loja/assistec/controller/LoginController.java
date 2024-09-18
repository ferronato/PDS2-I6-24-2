package br.com.loja.assistec.controller;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.com.loja.assistec.model.UsuarioModel;
import br.com.loja.assistec.view.LoginView;
import br.com.loja.assistec.view.PrincipalView;

public class LoginController {
	
	private LoginView view;
	private UsuarioModel model;

	public LoginController(LoginView view) {
		this.view = view;
		this.model = new UsuarioModel();
		 if (model.conexao != null){
//			 System.out.println("conectado");
//	            view.lblStatus.setText("Conectado!");
	            view.lblStatus.setIcon(new ImageIcon(getClass().getResource("/br/com/loja/assistec/icones/dbok.png")));
	        } else{
//	        	System.out.println("conectado");
//	            view.lblStatus.setText("Não Conectado!");
	            view.lblStatus.setIcon(new ImageIcon(getClass().getResource("/br/com/loja/assistec/icones/dberror.png")));
	        }
//		 this.model.fecharConexao(); //Retirar depois
		this.view.btnLogin.addActionListener(e -> logar());
	}

	public void logar() {
		String login = view.txtUsuario.getText();
		String senha = new String(view.txtSenha.getPassword());

		String perfil = model.autenticar(login, senha);

		if (perfil != null) {
			PrincipalView principal = new PrincipalView();
			principal.setVisible(true);
			if ("admin".equals(perfil)) {
				PrincipalView.MenuRelatorio.setEnabled(true);
				PrincipalView.MenuCadastroUsuarios.setEnabled(true);
			}
			PrincipalView.lblUsuario.setText(login);
			view.dispose();
			model.fecharConexao();
		} else {
			JOptionPane.showMessageDialog(null, "Login ou Senha Inválidos!");
		}
	}
	
}
