package br.ufc.qxd.persistencia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuView {

	private JFrame frmPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView window = new MenuView();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("TI SOLUTIONS");
		frmPrincipal.setBounds(100, 100, 587, 353);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmDepartamento = new JMenuItem("Departamento");
		mntmDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartamentoView view = new DepartamentoView();
				view.open();
			}
		});
		mnCadastro.add(mntmDepartamento);
		
		JMenuItem mntmProjeto = new JMenuItem("Projeto");
		mntmProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjetoView view = new ProjetoView();
				view.open();
			}
		});
		mnCadastro.add(mntmProjeto);
		
		JMenuItem mntmFuncionario = new JMenuItem("Funcionario");
		mntmFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				FuncionarioView view = new FuncionarioView();
				view.open();
			}
		});
		mnCadastro.add(mntmFuncionario);
		
		JMenuItem mntmDependente = new JMenuItem("Dependente");
		mntmDependente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DependenteView view = new DependenteView();
				view.open();
			}
		});
		mnCadastro.add(mntmDependente);
		
		JMenu mnVinculos = new JMenu("Vinculos");
		menuBar.add(mnVinculos);
		
		JMenuItem mntmSupervisores = new JMenuItem("Supervisores");
		mntmSupervisores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupervisaoView view = new SupervisaoView();
				view.open();
			}
		});
		mnVinculos.add(mntmSupervisores);
		
		JMenuItem mntmAlocacaoDeProjetos = new JMenuItem("Alocacao de Projetos");
		mntmAlocacaoDeProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlocacaoView view = new AlocacaoView();
				view.open();
			}
		});
		mnVinculos.add(mntmAlocacaoDeProjetos);
		frmPrincipal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 581, 302);
		lblNewLabel.setIcon(new ImageIcon("./images/Company.jpg"));
		frmPrincipal.getContentPane().add(lblNewLabel);
	}
}
