package com.rapaul.shopping_mall.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import com.rapaul.shopping_mall.dao.UserDao;
import com.rapaul.shopping_mall.dto.UserLoginRequest;
import com.rapaul.shopping_mall.dto.UserLoginResponse;
import com.rapaul.shopping_mall.dto.UserRegisterRequest;
import com.rapaul.shopping_mall.model.User;
import com.rapaul.shopping_mall.service.UserService;
import com.rapaul.shopping_mall.util.JwtUtil;

@Component
public class UserServiceImpl implements UserService{
	
	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public Integer register(UserRegisterRequest userRegisterRequest) {
		
		// 檢查帳號是否重複
		User user = userDao.getUserByAccount(userRegisterRequest.getAccount());
		
		if(user != null) {
			log.warn("該 account {} 已經被註冊", userRegisterRequest.getAccount());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		// 使用 MD5 生成密碼的雜湊值
		String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
		userRegisterRequest.setPassword(hashedPassword);
		
		// 創建帳號
		return userDao.createUser(userRegisterRequest);

	}



	@Override
	public User getUserById(Integer UserId) {
		return userDao.getUserById(UserId);
	}
	



	@Override
	public UserLoginResponse login(UserLoginRequest userLoginRequest) {
		
		User user = userDao.getUserByAccount(userLoginRequest.getAccount());
		
		// 檢查 user 是否存在
		if(user == null) {
			log.warn("該 account {} 尚未註冊", userLoginRequest.getAccount());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		// 使用 MD5 生成密碼的雜湊值
		String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());
		
		// 比較密碼
		if(user.getPassword().equals(hashedPassword)) {
			
			String token = JwtUtil.generateToken(user.getAccount(), user.getUserId());
			
			UserLoginResponse userLoginResponse = new UserLoginResponse();
			userLoginResponse.setToken(token);
			userLoginResponse.setUser(user);
			
			return userLoginResponse;
			
		}else {
			log.warn("account {} 的密碼不正確", userLoginRequest.getAccount());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		
	}

}
