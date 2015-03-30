package com.buildsaas.model;

/**
 * Tenant entity. @author MyEclipse Persistence Tools
 */

public class Tenant implements java.io.Serializable {

	// Fields

	private Integer tenantId;
	private String tenantCompany;
	private String tenantPmsn;
	private String tenantRealname;
	private String tenantMobile;
	private String tenantPassword;
	private String tenantUsername;
	private String tenantEmail;
	private Integer tenantStatus;

	// Constructors

	/** default constructor */
	public Tenant() {
	}

	/** full constructor */
	public Tenant(String tenantCompany, String tenantPmsn,
			String tenantRealname, String tenantMobile, String tenantPassword,
			String tenantUsername, String tenantEmail, Integer tenantStatus) {
		this.tenantCompany = tenantCompany;
		this.tenantPmsn = tenantPmsn;
		this.tenantRealname = tenantRealname;
		this.tenantMobile = tenantMobile;
		this.tenantPassword = tenantPassword;
		this.tenantUsername = tenantUsername;
		this.tenantEmail = tenantEmail;
		this.tenantStatus = tenantStatus;
	}

	// Property accessors

	public Integer getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantCompany() {
		return this.tenantCompany;
	}

	public void setTenantCompany(String tenantCompany) {
		this.tenantCompany = tenantCompany;
	}

	public String getTenantPmsn() {
		return this.tenantPmsn;
	}

	public void setTenantPmsn(String tenantPmsn) {
		this.tenantPmsn = tenantPmsn;
	}

	public String getTenantRealname() {
		return this.tenantRealname;
	}

	public void setTenantRealname(String tenantRealname) {
		this.tenantRealname = tenantRealname;
	}

	public String getTenantMobile() {
		return this.tenantMobile;
	}

	public void setTenantMobile(String tenantMobile) {
		this.tenantMobile = tenantMobile;
	}

	public String getTenantPassword() {
		return this.tenantPassword;
	}

	public void setTenantPassword(String tenantPassword) {
		this.tenantPassword = tenantPassword;
	}

	public String getTenantUsername() {
		return this.tenantUsername;
	}

	public void setTenantUsername(String tenantUsername) {
		this.tenantUsername = tenantUsername;
	}

	public String getTenantEmail() {
		return this.tenantEmail;
	}

	public void setTenantEmail(String tenantEmail) {
		this.tenantEmail = tenantEmail;
	}

	public Integer getTenantStatus() {
		return this.tenantStatus;
	}

	public void setTenantStatus(Integer tenantStatus) {
		this.tenantStatus = tenantStatus;
	}

}