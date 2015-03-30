package com.buildsaas.service;

import com.buildsaas.model.Tenant;

public interface TenantService {

	public String register(Tenant tenant);

	public String login(String username, String password);
	
	public String isReged(String username);
}
