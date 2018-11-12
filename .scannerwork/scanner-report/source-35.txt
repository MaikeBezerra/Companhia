package br.ufc.qxd.persistencia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.NoResultException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.validation.ConstraintViolationException;

import br.ufc.qxd.persistencia.bean.Departamento;
import br.ufc.qxd.persistencia.dao.impl.DepartamentoJPADAO;
import br.ufc.qxd.persistencia.view.field.FieldInteger;
import br.ufc.qxd.persistencia.view.field.StringField;

public class DepartamentoView {
	
	private DepartamentoJPADAO depDAO = new DepartamentoJPADAO();
	private Departamento dep;
	
	private JFrame frmDepartamento;
	private JTextField txtNome;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartamentoView window = new DepartamentoView();
					window.frmDepartamento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DepartamentoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		FieldInteger fieldInteger = new FieldInteger();
		StringField stringField = new StringField();
		
		//Frame
		frmDepartamento = new JFrame();
		frmDepartamento.setTitle("Departamento");
		frmDepartamento.setBounds(100, 100, 489, 202);
		frmDepartamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDepartamento.getContentPane().setLayout(null);
		
		//Labels
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(123, 34, 70, 15);
		frmDepartamento.getContentPane().add(lblNome);
		
		JLabel lblNumero = new JLabel("ID");
		lblNumero.setBounds(35, 34, 70, 15);
		frmDepartamento.getContentPane().add(lblNumero);
		
		//FieldTexts
		txtId = new JTextField();
		txtId.addKeyListener(fieldInteger);
		txtId.setBounds(34, 57, 71, 19);
		frmDepartamento.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(stringField);
		txtNome.setBounds(123, 57, 278, 19);
		frmDepartamento.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		//Buttons
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					if (!txtId.getText().equals("")) {
						int id = Integer.parseInt(txtId.getText());
						dep = depDAO.find(id);
					} else if (!txtNome.getText().equals("")) {
						dep = depDAO.findByName(txtNome.getText());
					} 
					
					if (dep == null ) {
						JOptionPane.showMessageDialog(null, "Departamento não encontrado");
						txtId.setText("");
						txtNome.setText("");
					} else {
						txtId.setText(Integer.toString(dep.getId()));
						txtNome.setText(dep.getNome());
					}
				} catch (NoResultException e) {
					JOptionPane.showMessageDialog(null, "Departamento não encontrado");
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(413, 51, 25, 25);
		frmDepartamento.getContentPane().add(btnBuscar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!txtId.getText().equals("")) {
						int id = Integer.parseInt(txtId.getText());
						dep = new Departamento(id, txtNome.getText());
						
					} else {
						dep = new Departamento(txtNome.getText());
					}
					depDAO.beginTransaction();
					depDAO.save(dep);
					depDAO.commit();
					depDAO.close();
					JOptionPane.showMessageDialog(null, "Departamento salvo com sucesso!");
				} catch (ConstraintViolationException e2) {
					JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio");
				}
				
			}
		});
		btnSalvar.setBounds(138, 104, 102, 25);
		frmDepartamento.getContentPane().add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (dep != null) {
					depDAO.beginTransaction();
					depDAO.delete(dep.getId());
					depDAO.commit();
					depDAO.close();
					JOptionPane.showMessageDialog(null, "Departamento excluido com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Realize a busca do Departameto");
				}
				
			}
		});
		btnExcluir.setBounds(255, 104, 102, 25);
		frmDepartamento.getContentPane().add(btnExcluir);
	}
}
