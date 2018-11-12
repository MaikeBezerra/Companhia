package br.ufc.qxd.persistencia.dao;

import java.util.List;

import br.ufc.qxd.persistencia.bean.Departamento;

public interface DepartamentoDAO extends GenericDAO<Departamento>{
	
	public Departamento findByName(String nome);
	
	public List<String> findAllName();
}
