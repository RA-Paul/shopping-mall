package com.rapaul.shopping_mall.dao;

import com.rapaul.shopping_mall.dto.UserRegisterRequest;
import com.rapaul.shopping_mall.model.User;

public interface UserDao {
	
	// 創建使用者
	Integer createUser(UserRegisterRequest userRegisterRequest);
	
	// 透過Id獲取使用者	
	User getUserById(Integer userId);
	
	// 透過帳號獲取使用者	
	User getUserByAccount(String account);
	
}
