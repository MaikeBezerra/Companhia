package br.ufc.qxd.persistencia.dao;

import br.ufc.qxd.persistencia.bean.Pesquisador;

public interface PesquisadorDAO extends GenericDAO<Pesquisador>{

	Pesquisador findByName(String nome);

}
