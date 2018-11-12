package br.ufc.qxd.persistencia.dao.impl;

import br.ufc.qxd.persistencia.bean.Projeto;
import br.ufc.qxd.persistencia.dao.ProjetoDAO;
import br.ufc.qxd.persistencia.util.JPAUtil;

public class ProjetoJPADAO extends GenericJPADAO<Projeto> 
							implements ProjetoDAO{

	public ProjetoJPADAO() {
		super(Projeto.class);
	}

	@Override
	public Projeto findByName(String nome) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Projeto.findByName", Projeto.class)
				.setParameter("nome", nome).getSingleResult();
	}
	
}
