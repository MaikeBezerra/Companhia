package br.ufc.qxd.persistencia.dao;

import java.util.List;
import br.ufc.qxd.persistencia.bean.Bean;

public interface GenericDAO<T extends Bean> {
	public void save(T entity);
	public void delete(Object id);
	public T find(Object id);
	public List<T> findAll();
	public void beginTransaction();
	public void commit();
	public void rollback();
	public void close();
}
