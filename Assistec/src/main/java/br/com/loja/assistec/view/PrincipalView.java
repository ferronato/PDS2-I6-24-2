package br.com.loja.assistec.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class PrincipalView extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JMenu MenuRelatorio;
	public static JMenu MenuCadastroUsuarios;
	public static JLabel lblUsuario;
	private JMenuBar menuBar;
	private JMenu menuArquivo;
	private JMenuItem menuSair;
	private JMenu menuAjuda;
	private JMenuItem menuSobre;

	public PrincipalView() {
		initComponents();
	}

	public void initComponents() {
		lblUsuario = new JLabel();
		menuBar = new JMenuBar();
		menuArquivo = new JMenu();
		menuSair = new JMenuItem();
		MenuCadastroUsuarios = new JMenu();
		MenuRelatorio = new JMenu();
		menuAjuda = new JMenu();
		menuSobre = new JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Sistema de Gestão - Tela Principal");
		setResizable(false);

		lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		lblUsuario.setText("Usuário");

		// Configurando Menu "Arquivo"
		menuArquivo.setText("Arquivo");

		menuSair.setText("Sair");
		menuSair.addActionListener(evt -> menuSairActionPerformed(evt));
		menuArquivo.add(menuSair);

		menuBar.add(menuArquivo);

		// Configurando Menu "Cadastro de Usuários"
		MenuCadastroUsuarios.setText("Cadastro de Usuários");
		MenuCadastroUsuarios.setEnabled(false); // Desabilitado por padrão para usuários não administradores
		menuBar.add(MenuCadastroUsuarios);

		// Configurando Menu "Relatórios"
		MenuRelatorio.setText("Relatórios");
		MenuRelatorio.setEnabled(false); // Desabilitado por padrão para usuários não administradores
		menuBar.add(MenuRelatorio);

		// Configurando Menu "Ajuda"
		menuAjuda.setText("Ajuda");

		menuSobre.setText("Sobre");
		menuSobre.addActionListener(evt -> menuSobreActionPerformed(evt));
		menuAjuda.add(menuSobre);

		menuBar.add(menuAjuda);

		setJMenuBar(menuBar);

		// Layout do JFrame
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addComponent(lblUsuario)
						.addContainerGap(330, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addComponent(lblUsuario)
						.addContainerGap(250, Short.MAX_VALUE)));

		pack();
		setLocationRelativeTo(null);
	}

	private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {
		int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (sair == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null, "Sistema de Gestão - Versão 1.0");
	}

}
