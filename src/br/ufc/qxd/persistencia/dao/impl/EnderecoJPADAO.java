package br.ufc.qxd.persistencia.dao.impl;

import br.ufc.qxd.persistencia.bean.Endereco;
import br.ufc.qxd.persistencia.dao.EnderecoDAO;

public class EnderecoJPADAO extends GenericJPADAO<Endereco> implements EnderecoDAO{

	public EnderecoJPADAO() {
		super(Endereco.class);
	}

}
