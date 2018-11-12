package br.ufc.qxd.persistencia.dao.impl;

import br.ufc.qxd.persistencia.bean.Pesquisador;
import br.ufc.qxd.persistencia.dao.PesquisadorDAO;
import br.ufc.qxd.persistencia.util.JPAUtil;

public class PesquisadorJPADAO extends GenericJPADAO<Pesquisador> 
implements PesquisadorDAO{

	public PesquisadorJPADAO() {
		super(Pesquisador.class);
		
	}
	
	@Override
	public Pesquisador findByName(String nome) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Pesquisador.findByName", Pesquisador.class)
				.setParameter("nome", nome).getSingleResult();
	}

}
