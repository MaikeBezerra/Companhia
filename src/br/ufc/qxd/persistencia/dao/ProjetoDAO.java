package br.ufc.qxd.persistencia.dao;

import br.ufc.qxd.persistencia.bean.Projeto;

public interface ProjetoDAO extends GenericDAO<Projeto>{
	public Projeto findByName(String nome);
}
