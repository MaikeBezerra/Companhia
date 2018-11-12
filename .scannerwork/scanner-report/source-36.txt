package br.ufc.qxd.persistencia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.NoResultException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.validation.ConstraintViolationException;

import br.ufc.qxd.persistencia.bean.Departamento;
import br.ufc.qxd.persistencia.bean.Projeto;
import br.ufc.qxd.persistencia.dao.impl.DepartamentoJPADAO;
import br.ufc.qxd.persistencia.dao.impl.ProjetoJPADAO;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ProjetoView {

	private DepartamentoJPADAO depDAO = new DepartamentoJPADAO();
	private ProjetoJPADAO projDAO = new ProjetoJPADAO();
	private Projeto projeto;
	
	private JFrame frmProjeto;
	private JTextField txtNome;
	private JTextField txtPeriodo;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjetoView window = new ProjetoView();
					window.frmProjeto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProjetoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjeto = new JFrame();
		frmProjeto.setTitle("Projeto");
		frmProjeto.setBounds(100, 100, 450, 177);
		frmProjeto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmProjeto.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(24, 12, 70, 15);
		frmProjeto.getContentPane().add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(94, 12, 70, 15);
		frmProjeto.getContentPane().add(lblNome);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setBounds(24, 61, 70, 15);
		frmProjeto.getContentPane().add(lblPeriodo);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(94, 61, 122, 15);
		frmProjeto.getContentPane().add(lblDepartamento);
		
		txtId = new JTextField();
		txtId.setBounds(24, 30, 58, 19);
		frmProjeto.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(94, 30, 291, 19);
		frmProjeto.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setBounds(24, 77, 58, 19);
		frmProjeto.getContentPane().add(txtPeriodo);
		txtPeriodo.setColumns(10);
		
		JComboBox<String> cmbBxDepartamento = new JComboBox<String>();
		cmbBxDepartamento.setBounds(94, 74, 246, 24);
		cmbBxDepartamento.setModel(new DefaultComboBoxModel<String>(depDAO.depsGetName()));
		frmProjeto.getContentPane().add(cmbBxDepartamento);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					if (!txtId.getText().equals("")) {
						int id = Integer.parseInt(txtId.getText());
						projeto = projDAO.find(id);
					} else if (!txtNome.getText().equals("")) {
						projeto = projDAO.findByName(txtNome.getText());
					} 
					
					if (projeto == null) {
						JOptionPane.showMessageDialog(null, "Projeto não encontrado");
						txtId.setText("");
						txtNome.setText("");
					} else {
						txtId.setText(Integer.toString(projeto.getId()));
						txtNome.setText(projeto.getNome());
						txtPeriodo.setText(Integer.toString(projeto.getPeriodo()));
						Departamento dep = projeto.getDepartamento();
						cmbBxDepartamento.setSelectedItem(dep.getNome());
					}
				} catch (NoResultException e) {
					JOptionPane.showMessageDialog(null, "Projeto não encontrado");
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(399, 25, 33, 24);
		frmProjeto.getContentPane().add(btnBuscar);
		
		
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon("./images/icons/save.png"));
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					
					String nome = txtNome.getText();
					int periodo = Integer.parseInt(txtPeriodo.getText());
					
					String nomeDepartamento = cmbBxDepartamento.getSelectedItem().toString();
					Departamento departamento = depDAO.findByName(nomeDepartamento);
					
					if (!txtId.getText().equals("")) {
						int id = Integer.parseInt(txtId.getText());
						projeto = new Projeto(id, nome, periodo, departamento);
					} else {
						projeto = new Projeto(nome, periodo, departamento);
					}
					projDAO.beginTransaction();
					projDAO.save(projeto);
					projDAO.commit();
					projDAO.close();
					JOptionPane.showMessageDialog(null, "Projeto salvo com sucesso!");
				} catch (ConstraintViolationException e2) {
					JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio");
				}
			}
		});
		btnSalvar.setBounds(354, 71, 33, 25);
		frmProjeto.getContentPane().add(btnSalvar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (projeto != null) {
					projDAO.beginTransaction();
					projDAO.delete(projeto.getId());
					projDAO.commit();
					projDAO.close();
					JOptionPane.showMessageDialog(null, "Projeto excluido com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Realize a busca do Projeto");
				}
			}
		});
		btnExcluir.setIcon(new ImageIcon("./images/icons/bin.png"));
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(399, 71, 33, 25);
		frmProjeto.getContentPane().add(btnExcluir);
	}
}
