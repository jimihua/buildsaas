package com.buildsaas.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.buildsaas.dao.TenantDao;
import com.buildsaas.model.Tenant;
import com.buildsaas.service.TenantService;

@Service("tenantService")
public class TenantServiceImpl implements TenantService {
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	@Resource(name = "tenantDao")
	private TenantDao tenantDao;

	public TenantDao getTenantDao() {
		return tenantDao;
	}

	public void setTenantDao(TenantDao tenantDao) {
		this.tenantDao = tenantDao;
	}

	@Override
	public String register(Tenant tenant) {
		if (this.tenantDao.isReged(tenant.getTenantUsername())) {

			return "is reged";
		}
		return this.tenantDao.register(tenant);

	}

	/**
	 * @author zeb 创建时间：2015年3月30日 下午12:23:38
	 * 
	 */
	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		if (username == null) {
			return "username is null";
		}
		if (password == null) {
			return "password is null";
		}
		if (!this.tenantDao.isReged(username)) {
			return "the username is not reg";
		}
		if (this.tenantDao.login(username, password).equals("success")) {
			return "success";
		} else {
			return "password is wrong";
		}

	}

	/**
	 * @author zeb 创建时间：2015年3月30日 下午2:09:25
	 * 
	 */
	@Override
	public String isReged(String username) {
		// TODO Auto-generated method stub
		if (username == null) {
			return ERROR;
		}
		if (this.tenantDao.isReged(username)) {
			return ERROR;
		} else {
			return SUCCESS;
		}

	}

	@Override
	public List<Tenant> listAll(int page, int number) {
		// TODO Auto-generated method stub
		return this.tenantDao.listAll(page, number);
	}

}
