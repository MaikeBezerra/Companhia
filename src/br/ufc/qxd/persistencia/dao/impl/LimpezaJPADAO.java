package br.ufc.qxd.persistencia.dao.impl;

import br.ufc.qxd.persistencia.bean.Limpeza;
import br.ufc.qxd.persistencia.dao.LimpezaDAO;
import br.ufc.qxd.persistencia.util.JPAUtil;

public class LimpezaJPADAO extends GenericJPADAO<Limpeza> implements LimpezaDAO{

	public LimpezaJPADAO() {
		super(Limpeza.class);
	}

	@Override
	public Limpeza findByName(String nome) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Limpeza.findByName", Limpeza.class)
				.setParameter("nome", nome).getSingleResult();
	}
	
	public String[] supervisionadosGetNames(String nome){
		Limpeza f = this.findByName(nome);
		return supervisionadosGetNames(f);
	}
	
	public String[] supervisionadosGetNames(int id){
		Limpeza f = this.find(id);
		return supervisionadosGetNames(f);
	}
	
	public String[] supervisionadosGetNames(Limpeza f){
		String supervisionados[] = new String[f.getSupervionados().size()];
		
		int i = 0;
		for (Limpeza l : f.getSupervionados()) {
			supervisionados[i] = l.getNome();
			i++;
		}
		
		return supervisionados;
	}
}
