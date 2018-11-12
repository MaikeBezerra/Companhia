package br.ufc.qxd.persistencia.dao.impl;

import br.ufc.qxd.persistencia.bean.PesquisadoresProjetos;
import br.ufc.qxd.persistencia.dao.PesquisadoresProjetosDAO;

public class PesquisadoresProjetosJPADAO extends GenericJPADAO<PesquisadoresProjetos> implements
																	PesquisadoresProjetosDAO{

	public PesquisadoresProjetosJPADAO() {
		super(PesquisadoresProjetos.class);
	}

}
