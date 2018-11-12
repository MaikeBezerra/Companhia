package br.ufc.qxd.persistencia.dao;

import br.ufc.qxd.persistencia.bean.Limpeza;

public interface LimpezaDAO extends GenericDAO<Limpeza>{
	public Limpeza findByName(String nome);
}
