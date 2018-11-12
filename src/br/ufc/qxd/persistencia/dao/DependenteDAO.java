package br.ufc.qxd.persistencia.dao;

import java.util.List;

import br.ufc.qxd.persistencia.bean.Dependente;

public interface DependenteDAO extends GenericDAO<Dependente>{
	public Dependente findByName(String nome);
	public List<String> findAllName(int id);
}
