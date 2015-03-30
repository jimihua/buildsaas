/**
 * 
 */
package com.buildsaas.daoImpl;

import javax.annotation.Resource;

import org.aspectj.apache.bcel.generic.GETSTATIC;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author yxq
 * @date 2014年9月29日上午9:43:35
 * @email 2571094456@qq.com
 */
public class AbstractDao {
	@Resource(name = "sessionFactory")
	SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

}
