package com.buildsaas.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.buildsaas.dao.BaseDao;


/**
 * @author yxq
 * 
 * @param <T>
 */
@Component("baseDao")
@Transactional
@SuppressWarnings("all")
public class BaseDaoImpl<T> extends AbstractDao implements BaseDao<T> {
	private static Logger logger = Logger.getLogger(BaseDaoImpl.class);

	private Class<T> persistentClass;

	/**
	 * 数据操作语句的批处理大小设置为50
	 */
	protected static final int UpdateBatchSize = 50;

	public BaseDaoImpl() {

	}

	@Override
	public String getSimpleName() {
		return this.persistentClass.getSimpleName();
	}

	/**
	 * @return the persistentClass
	 */
	public Class<T> getPersistentClass() {
		return this.persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * 标记实体类型。
	 */
	protected final String getType() {
		return this.getSimpleName().toLowerCase();
	}

	/**
	 * 默认构造函数，用于获取范型<code>T</code>的带有类型化信息的<code>Class</code>对象
	 */
	public BaseDaoImpl(Class<T> persistentClass) {
		this.setPersistentClass(persistentClass);
	}

	@Override
	public Long generateUniqueIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public T findById(Integer id) { return (T)
	 * this.getSession().get(this.getPersistentClass(), id); }
	 */

	@Override
	public T save(T entity) {
		Session session = this.getSession();
		this.getSession().save(entity);
		session.flush();
		session.clear();
		return entity;
	}

	@Override
	public List<T> saveAll(List<T> entities) {
		Session session = this.getSession();
		for (int i = 0; i < entities.size(); i++) {
			session.save(entities.get(i));
			if (i % UpdateBatchSize == 0) {
				session.flush();
				session.clear();
			}
		}

		return null;
	}

	@Override
	public void delete(T entity) {
		this.getSession().delete(entity);
	}

	@Override
	public void delete(Integer entityId) {
		// Session session = this.getSession();
		final String hql = "delete from " + this.getSimpleName()
				+ " where id = :entityId";
		try {
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			query.setParameter("entityId", entityId);
			query.uniqueResult();
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
	}

	@Override
	public T update(T entity) {
		this.getSession().update(entity);
		this.getSession().flush();
		return null;
	}

	@Override
	public List<T> updateAll(List<T> entities) {
		Session session = this.getSession();
		for (int i = 0; i < entities.size(); i++) {
			session.update(entities.get(i));
			if (i % UpdateBatchSize == 0) {
				session.flush();
				session.clear();
			}
		}
		return null;
	}

	@Override
	public T saveOrUpdate(T entity) {
		this.getSession().saveOrUpdate(entity);
		return null;
	}

	@Override
	public List<T> saveOrUpdateAll(List<T> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T merge(T entity) {
		this.getSession().merge(entity);
		return null;
	}

	@Override
	public void refresh(T entity) {
		this.getSession().refresh(entity);

	}

	@Override
	public void flush() {
		this.getSession().flush();
	}

	@Override
	public List<T> listAll() {
		return this.getSession().createQuery(" *from " + this.getSimpleName())
				.list();
	}

}
