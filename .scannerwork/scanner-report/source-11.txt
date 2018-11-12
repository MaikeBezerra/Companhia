package br.ufc.qxd.persistencia.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import br.ufc.qxd.persistencia.bean.Bean;
import br.ufc.qxd.persistencia.dao.GenericDAO;
import br.ufc.qxd.persistencia.util.JPAUtil;

public abstract class GenericJPADAO<T extends Bean> implements GenericDAO<T>{
	
	Class<T> persistenceClass;
	
	public GenericJPADAO(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
	}

	@Override
	public void save(T entity) {
		T t = JPAUtil.getEntityManager().merge(entity);
		entity.setId(t.getId());
	}

	@Override
	public void delete(Object id) {
		JPAUtil.getEntityManager().remove(this.find(id));
	}

	@Override
	public T find(Object id) {
		return JPAUtil.getEntityManager().find(persistenceClass, id);
	}

	@Override
	public List<T> findAll() {
		CriteriaQuery<T> cq = JPAUtil.getEntityManager().getCriteriaBuilder(). 
				createQuery(persistenceClass);
		cq.from(persistenceClass);
		return JPAUtil.getEntityManager().createQuery(cq).getResultList();
	}

	@Override
	public void beginTransaction() {
		JPAUtil.beginTransaction();
	}

	@Override
	public void commit() {
		JPAUtil.commit();
	}

	@Override
	public void rollback() {
		JPAUtil.rollback();
	}
	
	@Override
	public void close() {
		JPAUtil.closeEntityManager();
	} 

}
