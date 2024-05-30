package com.rapaul.shopping_mall.service;

import com.rapaul.shopping_mall.dto.UserLoginRequest;
import com.rapaul.shopping_mall.dto.UserLoginResponse;
import com.rapaul.shopping_mall.dto.UserRegisterRequest;
import com.rapaul.shopping_mall.model.User;

public interface UserService {
	
	Integer register(UserRegisterRequest userRegisterRequest);
	
	User getUserById(Integer UserId);
	
	UserLoginResponse login(UserLoginRequest userLoginRequest);
	
}
