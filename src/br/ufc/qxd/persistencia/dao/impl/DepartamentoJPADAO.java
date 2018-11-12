package br.ufc.qxd.persistencia.dao.impl;

import java.util.List;

import br.ufc.qxd.persistencia.bean.Departamento;
import br.ufc.qxd.persistencia.dao.DepartamentoDAO;
import br.ufc.qxd.persistencia.util.JPAUtil;

public class DepartamentoJPADAO extends GenericJPADAO<Departamento> 
									implements DepartamentoDAO{

	public DepartamentoJPADAO() {
		super(Departamento.class);
	}
	
	@Override
	public Departamento findByName(String nome){
		return JPAUtil.getEntityManager()
				.createNamedQuery("Departamento.findByName", Departamento.class)
				.setParameter("nome", nome).getSingleResult();
	}
	
	public String[] depsGetName(){
		List<String> nomes = this.findAllName();
		String deps[] = new String[nomes.size()];
		
		int i = 0;
		for (String s : nomes) {
			deps[i] = s;
			i++;
		}
		return deps;
	}

	@Override
	public List<String> findAllName() {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Departamento.findAllName", String.class).getResultList();
	}

}
