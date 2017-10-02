/**
 * 
 */
package com.bnu.springdemo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Muhammad Haris
 * 
 */
@Repository
public class GenericDAO<T> {

	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;

	public GenericDAO() {
		super();
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void insertOrUpdate(T baseModel) throws Exception {
		getHibernateTemplate().saveOrUpdate(baseModel);
	}

	public void insertOrUpdateAll(List<T> baseModels) throws Exception {
		getHibernateTemplate().saveOrUpdateAll(baseModels);
	}

	public void delete(T baseModel) throws Exception {
		getHibernateTemplate().delete(baseModel);
	}

	public T findByPrimarKey(Class entityClass, Long id) throws Exception {
		Object object = getHibernateTemplate().get(entityClass, id);
		return (T) object;
	}

	public List<T> findAll(Class entityClass) throws Exception {
		return getHibernateTemplate().loadAll(entityClass);
	}

	public List<T> findByExample(T baseModel) throws Exception {
		return this.getHibernateTemplate().findByExample(baseModel);
	}

	public Criteria createCriteria(Class entityClass) throws Exception {
		return getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(entityClass);
	}

	public List<T> findByNamedQuery(String queryName, Object... values) {
		try {
			return getHibernateTemplate().findByNamedQuery(queryName, values);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Query getNamedQuery(String queryName) throws Exception {
		return getHibernateTemplate().getSessionFactory().getCurrentSession()
				.getNamedQuery(queryName);
	}
}
