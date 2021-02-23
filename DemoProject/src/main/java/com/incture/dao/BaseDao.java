package com.incture.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incture.dto.BaseDto;
import com.incture.entities.BaseDo;

/**
 * @author Yash
 *
 * @param <E>
 * @param <D>
 */
@Repository
public abstract class BaseDao<E extends BaseDo, D extends BaseDto> {

	@Autowired
	private SessionFactory sessionFactory;

	// Use logger of log4j
	public final Logger logger = Logger.getLogger(getClass().getName());

	public abstract E importDto(D dto);

	public abstract D exportDto(E entity);

	public abstract List<E> importList(List<D> list);

	public abstract List<D> exportList(List<E> list);

	public Session getSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return sessionFactory.openSession();
		}
	}

	public void persist(E entity) {
		getSession().persist(entity);
	}

	public String save(E entity) {
		String primaryKey = (String) getSession().save(entity);
		return primaryKey;
	}

	public void update(E entity) {
		getSession().update(entity);

	}

	public void delete(E entity) {
		getSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	public E get(E entity) {
		E result = (E) getSession().load(entity.getClass(), (Serializable) entity.getPrimaryKey());
		return result;
	}

}
