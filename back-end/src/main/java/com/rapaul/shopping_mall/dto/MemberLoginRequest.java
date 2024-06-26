package com.rapaul.shopping_mall.dto;

import jakarta.validation.constraints.NotNull;

public class MemberLoginRequest {

	@NotNull
	private String account;
	
	@NotNull
	private String password;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
