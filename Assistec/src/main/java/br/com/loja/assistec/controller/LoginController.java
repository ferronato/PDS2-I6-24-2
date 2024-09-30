package br.com.loja.assistec.controller;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.com.loja.assistec.model.UsuarioModel;
import br.com.loja.assistec.view.LoginView;

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
			JOptionPane.showMessageDialog(null, "Aqui teremos o método logar!");
	}
	
}
