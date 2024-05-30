package com.rapaul.shopping_mall.dao;

import com.rapaul.shopping_mall.dto.MemberRegisterRequest;
import com.rapaul.shopping_mall.model.Member;

public interface MemberDao {
	// 創建會員
	Integer createMember(MemberRegisterRequest memberRegisterRequest);
	
	// 透過Id獲取會員
	Member getMemberById(Integer memberId);
	
	// 透過帳號獲取會員
	Member getMemberByAccount(String account);
}
