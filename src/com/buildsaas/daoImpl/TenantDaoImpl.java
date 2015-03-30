package com.buildsaas.daoImpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.buildsaas.dao.TenantDao;
import com.buildsaas.model.Tenant;

@Transactional
@Repository("tenantDao")
public class TenantDaoImpl extends BaseDaoImpl<Tenant> implements TenantDao {
	private static final String SUCCESS = "success";

	public TenantDaoImpl() {
		super(Tenant.class);

	}

	@Override
	public String register(Tenant tenant) {
		// TODO Auto-generated method stub
		this.getSession().save(tenant);
		return SUCCESS;
	}

	/**
	 * @author zeb 创建时间：2015年3月30日 下午12:24:07
	 * 
	 */
	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub

		return this
				.getSession()
				.createQuery(
						"from " + this.getSimpleName()
								+ " where tenant_username='" + username
								+ "' and tenant_password='" + password + "'")
				.list().size() == 0 ? "error" : "success";
	}

	/**
	 * @author zeb 创建时间：2015年3月30日 下午12:30:16
	 * 
	 */
	@Override
	public boolean isReged(String username) {
		// TODO Auto-generated method stub
		return this
				.getSession()
				.createQuery(
						"from " + this.getSimpleName()
								+ " where tenant_username='" + username+"'").list()
				.size() == 0 ? false : true;
	}
}
