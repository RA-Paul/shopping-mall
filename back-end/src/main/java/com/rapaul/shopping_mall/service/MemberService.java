package com.rapaul.shopping_mall.service;

import com.rapaul.shopping_mall.dto.MemberLoginRequest;
import com.rapaul.shopping_mall.dto.MemberLoginResponse;
import com.rapaul.shopping_mall.dto.MemberRegisterRequest;
import com.rapaul.shopping_mall.model.Member;

public interface MemberService {

	
	Integer register(MemberRegisterRequest memberRegisterRequest);
	
	Member getMemberById(Integer memberId);
	
	MemberLoginResponse login(MemberLoginRequest memberLoginRequest);
}
