package com.rapaul.shopping_mall.dto;

import com.rapaul.shopping_mall.model.Member;

public class MemberLoginResponse {

	private Member member;
	private String token;
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
