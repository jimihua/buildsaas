package com.buildsaas.model;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Integer tenantId;
	private String userPmsn;
	private String userRealname;
	private String userEmail;
	private String userPassword;
	private String userMobile;
	private String userName;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer tenantId) {
		this.tenantId = tenantId;
	}

	/** full constructor */
	public User(Integer tenantId, String userPmsn, String userRealname,
			String userEmail, String userPassword, String userMobile,
			String userName) {
		this.tenantId = tenantId;
		this.userPmsn = userPmsn;
		this.userRealname = userRealname;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userMobile = userMobile;
		this.userName = userName;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserPmsn() {
		return this.userPmsn;
	}

	public void setUserPmsn(String userPmsn) {
		this.userPmsn = userPmsn;
	}

	public String getUserRealname() {
		return this.userRealname;
	}

	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserMobile() {
		return this.userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}