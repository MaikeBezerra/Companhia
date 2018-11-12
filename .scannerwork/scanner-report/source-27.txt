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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import br.ufc.qxd.persistencia.bean.Limpeza;
import br.ufc.qxd.persistencia.dao.impl.LimpezaJPADAO;
import br.ufc.qxd.persistencia.view.field.FieldInteger;
import br.ufc.qxd.persistencia.view.field.StringField;

public class SupervisaoView {

	private Limpeza supervisor = new Limpeza();
	private Limpeza supervisionado = new Limpeza();
	
	private JFrame frame;
	private JPanel panel;
	private JLabel lbId;
	private JTextField txtId;
	private JLabel lbNome;
	private JTextField txtNome;
	private JLabel lblSupervisor;
	private JList<String> list;
	private JTextField txtIdSurp;
	private JTextField txtNomeSurp;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupervisaoView window = new SupervisaoView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SupervisaoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		FieldInteger integer = new FieldInteger();
		StringField string = new StringField();
		
		LimpezaJPADAO funcDAO = new LimpezaJPADAO();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 604, 374);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));
		panel.setBounds(36, 33, 517, 62);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lbId = new JLabel("ID");
		lbId.setBounds(12, 12, 70, 15);
		panel.add(lbId);
		
		lbNome = new JLabel("Nome");
		lbNome.setBounds(94, 12, 70, 15);
		panel.add(lbNome);
		
		txtId = new JTextField();
		txtId.addKeyListener(integer);
		txtId.setColumns(10);
		txtId.setBounds(13, 29, 70, 19);
		panel.add(txtId);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(string);
		txtNome.setColumns(10);
		txtNome.setBounds(94, 30, 365, 19);
		panel.add(txtNome);
		
		list = new JList<String>();
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));
		list.setBounds(36, 125, 444, 99);
		frame.getContentPane().add(list);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				try {
					if (!txtId.getText().equals("")) {
						int id = Integer.parseInt(txtId.getText());
						supervisor = funcDAO.find(id);
					} else if (!txtNome.getText().equals("")) {
						supervisor = funcDAO.findByName(txtNome.getText());
					} 
					
					if (supervisor == null) {
						JOptionPane.showMessageDialog(null, "Supervisor não encontrado");
						txtId.setText("");
						txtNome.setText("");
						list.setListData(new String[0]);
					} else {
						txtId.setText(Integer.toString(supervisor.getId()));
						txtNome.setText(supervisor.getNome());
						list.setListData(funcDAO.supervisionadosGetNames(supervisor));
					}
				} catch (NoResultException e1) {
					JOptionPane.showMessageDialog(null, "Supervisor não encontrado!");
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscar.setBounds(464, 23, 41, 25);
		panel.add(btnBuscar);
		
		lblSupervisor = new JLabel("Supervisor");
		lblSupervisor.setBounds(36, 12, 102, 15);
		frame.getContentPane().add(lblSupervisor);
		
		
		
		JLabel lblSupervisionados = new JLabel("Supervisionados");
		lblSupervisionados.setBounds(36, 107, 137, 15);
		frame.getContentPane().add(lblSupervisionados);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(36, 236, 517, 54);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("ID");
		label.setBounds(12, 12, 70, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Nome");
		label_1.setBounds(94, 12, 70, 15);
		panel_1.add(label_1);
		
		txtIdSurp = new JTextField();
		txtIdSurp.setColumns(10);
		txtIdSurp.setBounds(13, 29, 70, 19);
		panel_1.add(txtIdSurp);
		
		txtNomeSurp = new JTextField();
		txtNomeSurp.setColumns(10);
		txtNomeSurp.setBounds(94, 30, 365, 19);
		panel_1.add(txtNomeSurp);
		
		JButton btnBuscaSupervionado = new JButton("");
		btnBuscaSupervionado.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscaSupervionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					if (!txtIdSurp.getText().equals("")) {
						int id = Integer.parseInt(txtIdSurp.getText());
						supervisionado = funcDAO.find(id);
					} else if (!txtNomeSurp.getText().equals("")) {
						supervisionado = funcDAO.findByName(txtNomeSurp.getText());
					} 
					
					if (supervisionado == null) {
						JOptionPane.showMessageDialog(null, "Supervisionado não encontrado");
						txtIdSurp.setText("");
						txtNomeSurp.setText("");
					} else {
						txtIdSurp.setText(Integer.toString(supervisionado.getId()));
						txtNomeSurp.setText(supervisionado.getNome());
					}
				} catch (NoResultException e1) {
					JOptionPane.showMessageDialog(null, "Supervisionado não encontrado!");
				}
			}
		});
		btnBuscaSupervionado.setBounds(464, 23, 41, 25);
		panel_1.add(btnBuscaSupervionado);
		
		JButton btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (supervisionado != null && supervisor != null
											&& supervisionado != supervisor) {
					
					supervisionado.setSupervisor(supervisor);
					funcDAO.beginTransaction();
					funcDAO.save(supervisionado);
					funcDAO.commit();
					funcDAO.close();
				}
				
			}
		});
		btnNovo.setIcon(new ImageIcon("./images/icons/plus (2).png"));
		btnNovo.setBounds(501, 137, 40, 32);
		frame.getContentPane().add(btnNovo);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon("./images/icons/bin.png"));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = list.getSelectedValue().toString();
				if (!list.isSelectionEmpty()) {
					Limpeza func = funcDAO.findByName(nome);
					
					func.setSupervisor(null);
					funcDAO.beginTransaction();
					funcDAO.save(func);
					funcDAO.commit();
					funcDAO.close();
				}
			}
		});
		btnExcluir.setBounds(501, 181, 40, 32);
		frame.getContentPane().add(btnExcluir);
	}
}
