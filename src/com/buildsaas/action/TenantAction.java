package com.buildsaas.action;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.buildsaas.model.Tenant;
import com.buildsaas.service.TenantService;
import com.opensymphony.xwork2.ActionSupport;

public class TenantAction extends ActionSupport {
	@Resource(name = "tenantService")
	private TenantService tenantService;

	private String username;
	private String password;

	private String page;
	private String rows;

	public TenantService getTenantService() {
		return tenantService;
	}

	public void setTenantService(TenantService tenantService) {
		this.tenantService = tenantService;
	}

	private HashMap<String, Object> hashMap;

	public HashMap<String, Object> getHashMap() {
		return hashMap;
	}

	public void setHashMap(HashMap<String, Object> hashMap) {
		this.hashMap = hashMap;
	}

	private Tenant tenant;

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public TenantAction() {
		// TODO Auto-generated constructor stub
		hashMap = new HashMap<String, Object>();
	}

	public String register() {
		if (tenant == null) {
			hashMap.put("register", "no tennat");
			return "regSuccess";
		}
		if (tenant.getTenantMobile() == null) {
			hashMap.put("register", "no mobile");
			return "regSuccess";
		}
		if (this.tenantService.register(tenant).equals("success")) {
			hashMap.put("regitser", "success");
			return "regSuccess";
		}
		return "regSuccess";
	}

	public String login() {
		hashMap.put("login", this.tenantService.login(username, password));

		return "loginSuccess";
	}

	public String isReged() {
		hashMap.put("isReged", this.tenantService.isReged(username));
		return "isRegSuccess";
	}

	public String listAll() {

		int intPage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);

		int number = Integer.parseInt((rows == null || rows == "0") ? "10"
				: rows);

		int start = (intPage - 1) * number;
		List<Tenant> list = tenantService.listAll(intPage, number);
		hashMap.put("rows", list);
		//hashMap.put("total", list.size());
		return "listAllSuccess";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}
}
