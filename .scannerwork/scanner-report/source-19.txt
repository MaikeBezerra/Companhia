package br.ufc.qxd.persistencia.dao;

import br.ufc.qxd.persistencia.bean.Funcionario;

public interface FuncionarioDAO extends GenericDAO<Funcionario>{
	public Funcionario findByName(String nome);
}
