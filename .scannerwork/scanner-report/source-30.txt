package br.ufc.qxd.persistencia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.NoResultException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import br.ufc.qxd.persistencia.bean.Dependente;
import br.ufc.qxd.persistencia.bean.Funcionario;
import br.ufc.qxd.persistencia.dao.impl.DependenteJPADAO;
import br.ufc.qxd.persistencia.dao.impl.FuncionarioJPADAO;

public class DependenteView {
	
	private Funcionario funcionario;
	private Dependente dep;
	private JFrame frmDependentes;
	private JTextField txtNomeFunc;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtDataNascimento;
	private JTextField txtParentesco;
	
	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DependenteView window = new DependenteView();
					window.frmDependentes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DependenteView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		FuncionarioJPADAO funcDAO = new FuncionarioJPADAO();
		DependenteJPADAO dependenteJPADAO = new DependenteJPADAO();
		
		frmDependentes = new JFrame();
		frmDependentes.setTitle("Dependentes");
		frmDependentes.setBounds(100, 100, 514, 431);
		frmDependentes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDependentes.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(54, 267, 425, 109);
		frmDependentes.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 12, 70, 15);
		panel.add(lblNome);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setBounds(12, 63, 129, 15);
		panel.add(lblDataNascimento);
		
		JLabel lblParentesco = new JLabel("Parentesco");
		lblParentesco.setBounds(160, 63, 97, 15);
		panel.add(lblParentesco);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(313, 63, 42, 15);
		panel.add(lblSexo);
		
		txtNome = new JTextField();
		txtNome.setBounds(12, 32, 401, 19);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(12, 80, 129, 19);
		panel.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		txtParentesco = new JTextField();
		txtParentesco.setBounds(160, 80, 138, 19);
		panel.add(txtParentesco);
		txtParentesco.setColumns(10);
		
		JComboBox<String> boxSexo = new JComboBox<String>();
		boxSexo.setBounds(310, 77, 57, 24);
		panel.add(boxSexo);
		boxSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"M", "F"}));
		
		JLabel lblFuncionario = new JLabel("Funcionario");
		lblFuncionario.setBounds(54, 10, 95, 15);
		frmDependentes.getContentPane().add(lblFuncionario);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(61, 37, 70, 15);
		frmDependentes.getContentPane().add(lblId);
		
		JLabel lblNomeFunc = new JLabel("Nome");
		lblNomeFunc.setBounds(145, 37, 70, 15);
		frmDependentes.getContentPane().add(lblNomeFunc);
		
		JLabel lblDependente = new JLabel("Dependentes");
		lblDependente.setBounds(54, 96, 106, 15);
		frmDependentes.getContentPane().add(lblDependente);
		
		txtId = new JTextField();
		txtId.setBounds(61, 57, 76, 27);
		frmDependentes.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtNomeFunc = new JTextField();
		txtNomeFunc.setBounds(145, 57, 268, 27);
		frmDependentes.getContentPane().add(txtNomeFunc);
		txtNomeFunc.setColumns(10);
		
		JList<String> list = new JList<String>();
		list.setBounds(54, 111, 425, 108);
		frmDependentes.getContentPane().add(list);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					 
					if (!txtId.getText().equals("")) {
						int id = Integer.parseInt(txtId.getText());
						funcionario = funcDAO.find(id);
						list.setListData(dependenteJPADAO.depGetName(id));
					} else if (!txtNomeFunc.getText().equals("")) {
						funcionario = funcDAO.findByName(txtNomeFunc.getText());
					} 
					
					if (funcionario == null ) {
						JOptionPane.showMessageDialog(null, "Funcionario não encontrado");
						txtId.setText("");
						txtNomeFunc.setText("");
					} else {
						txtId.setText(Integer.toString(funcionario.getId()));
						txtNomeFunc.setText(funcionario.getNome());
						
					}
				} catch (NoResultException e) {
					JOptionPane.showMessageDialog(null, "Funcionario não encontrado");
				}		
			}
		});
		btnBuscar.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscar.setBounds(425, 57, 41, 25);
		frmDependentes.getContentPane().add(btnBuscar);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon("./images/icons/save.png"));
		btnSalvar.setBounds(379, 76, 34, 25);
		panel.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (funcionario != null) {
					char sexo;
					if (boxSexo.getSelectedItem().equals("M")) {
						sexo = 'M';
					} else
						sexo = 'F';
					
					String dataNasc = txtDataNascimento.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Calendar cal = Calendar.getInstance();
					
					try {
						cal.setTime(sdf.parse(dataNasc));
						
						if (dep != null) {
							int id = dep.getId();
							dep = new Dependente(id, txtNome.getText(), sexo, 
									cal, funcionario, txtParentesco.getText());
						} else {
							dep = new Dependente(txtNome.getText(), sexo, 
														cal, funcionario, txtParentesco.getText());
						}
						
						dependenteJPADAO.beginTransaction();
						dependenteJPADAO.save(dep);
						dependenteJPADAO.commit();
						JOptionPane.showMessageDialog(null, "Dependente Salvo");
						dep = null;
					} catch (ParseException e) {
						JOptionPane.showMessageDialog(null, "Erros possiveis no campo data");
						dependenteJPADAO.rollback();
					}
				} else 
					JOptionPane.showMessageDialog(null, "Funcionario não encontrado");
				
				dependenteJPADAO.close();
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!list.isSelectionEmpty()) {
					String nome = list.getSelectedValue();
					
					dep = dependenteJPADAO.findByName(nome);
					
					txtNome.setText(dep.getNome());
					txtParentesco.setText(dep.getParentesco());
					txtDataNascimento.setText(dep.getDate());
					if (dep.getSexo() == 'M') {
						boxSexo.setSelectedIndex(0);
					} else
						boxSexo.setSelectedIndex(1);
				} else
					JOptionPane.showMessageDialog(null, "Selecione o Dependente a ser editado");
				
			}
		});
		btnEditar.setBounds(170, 230, 95, 25);
		frmDependentes.getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!list.isSelectionEmpty()) {
					String nome = list.getSelectedValue();
					Dependente dependente = dependenteJPADAO.findByName(nome);
					dependenteJPADAO.beginTransaction();
					dependenteJPADAO.delete(dependente.getId());
					dependenteJPADAO.commit();
					dependenteJPADAO.close();
					JOptionPane.showMessageDialog(null, "Dependente excluido");
				} else
					JOptionPane.showMessageDialog(null, "Selecione o Dependente a ser excluido");
			}
		});
		btnExcluir.setBounds(277, 230, 96, 25);
		frmDependentes.getContentPane().add(btnExcluir);
	}
}
