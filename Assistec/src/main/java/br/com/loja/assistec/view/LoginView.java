package br.com.loja.assistec.view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.com.loja.assistec.controller.LoginController;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	LoginController controller = new LoginController();

	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JButton btnLogin;
	private JLabel lblStatus;
	private JLabel lblUsuario;
	private JLabel lblSenha;

	public LoginView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("CRUD - LOGIN");
		setResizable(false);

		//Inicializa todos elementos gráficos
		iniciarComponentes();
		
		getRootPane().setDefaultButton(btnLogin);
		
		//Neste comando o controller vai saber quem está chamando (LoginView)
		controller.executa(this);
	}

	public void iniciarComponentes() {
		lblUsuario = new JLabel();
		lblSenha = new JLabel();
		txtUsuario = new JTextField();
		txtSenha = new JPasswordField();
		btnLogin = new JButton();
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickBtnLogin();
			}
		});
		lblStatus = new JLabel();

		lblUsuario.setText("Usuário");
		lblSenha.setText("Senha");
		btnLogin.setText("Login");

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(37).addComponent(lblStatus))
						.addGroup(groupLayout.createSequentialGroup().addGap(189).addComponent(btnLogin))
						.addGroup(groupLayout.createSequentialGroup().addGap(130)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 36,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblUsuario))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 128,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 127,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(180, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap(60, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblUsuario).addComponent(
						txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblSenha)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addGap(35).addComponent(btnLogin).addGap(22).addComponent(lblStatus).addGap(61)));
		getContentPane().setLayout(groupLayout);
		pack();
		setLocationRelativeTo(null);
	}

	//Método chamado ao clicar no botão, vai acionar o método logar() no controller
	private void onClickBtnLogin() {
		controller.logar();
	}

	// Estes métodos devem ser public para serem usados do Controller
	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public JLabel getLblStatus() {
		return lblStatus;
	}

}
