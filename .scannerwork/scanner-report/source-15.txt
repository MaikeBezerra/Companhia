package br.ufc.qxd.persistencia.dao.impl;

import br.ufc.qxd.persistencia.bean.Funcionario;
import br.ufc.qxd.persistencia.dao.FuncionarioDAO;
import br.ufc.qxd.persistencia.util.JPAUtil;

public class FuncionarioJPADAO extends GenericJPADAO<Funcionario> implements FuncionarioDAO{

	public FuncionarioJPADAO() {
		super(Funcionario.class);
	}

	@Override
	public Funcionario findByName(String nome) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Funcionario.findByName", Funcionario.class)
				.setParameter("nome", nome).getSingleResult();
	}
	
	
}
