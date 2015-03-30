package com.buildsaas.dao;

import com.buildsaas.model.Tenant;

public interface TenantDao {

	public String register(Tenant tenant);

	public String login(String username, String password);

	public boolean isReged(String username);
}
