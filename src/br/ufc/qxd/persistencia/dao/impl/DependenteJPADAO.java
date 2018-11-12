package br.ufc.qxd.persistencia.dao.impl;

import java.util.List;

import br.ufc.qxd.persistencia.bean.Dependente;
import br.ufc.qxd.persistencia.dao.DependenteDAO;
import br.ufc.qxd.persistencia.util.JPAUtil;

public class DependenteJPADAO extends GenericJPADAO<Dependente> 
								implements DependenteDAO{

	public DependenteJPADAO() {
		super(Dependente.class);
	}

	public String[] depGetName(int id){
		List<String> nomes = this.findAllName(id);
		String deps[] = new String[nomes.size()];
		
		int i = 0;
		for (String s : nomes) {
			deps[i] = s;
			i++;
		}
		return deps;
	}

	@Override
	public List<String> findAllName(int id) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Dependente.findAllName", String.class)
				.setParameter("id", id).getResultList();
	}

	@Override
	public Dependente findByName(String nome) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Dependente.findByName", Dependente.class)
				.setParameter("nome", nome).getSingleResult();
	}
}
