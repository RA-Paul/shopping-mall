package com.rapaul.shopping_mall.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.rapaul.shopping_mall.dao.UserDao;
import com.rapaul.shopping_mall.dto.UserRegisterRequest;
import com.rapaul.shopping_mall.model.User;
import com.rapaul.shopping_mall.rowmapper.UserRowMapper;

@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	
	@Override
	public Integer createUser(UserRegisterRequest userRegisterRequest) {
		
		String sql = "CALL CreateUser(:account , :password , :createdDate , :lastModifiedDate, @userId);";
		
		Map<String, Object> map = new HashMap<>();
		map.put("account", userRegisterRequest.getAccount());
		map.put("password", userRegisterRequest.getPassword());
		
		Date now = new Date();
		map.put("createdDate", now);
		map.put("lastModifiedDate", now);
		
		namedParameterJdbcTemplate.update(sql, map);
		
		String sql1 = "SELECT @userId ;";
		Map<String, Object> map1 = new HashMap<>();
		int userId = namedParameterJdbcTemplate.queryForObject(sql1, map1, Integer.class);
		
		return userId;
	}


	@Override
	public User getUserById(Integer userId) {

		String sql = "CALL GetUserById(:userId);";
		
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		
		List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());
		
		if(userList.size() > 0) {
			return userList.get(0);
		}else {
			return null;
		}
	}


	@Override
	public User getUserByAccount(String account) {
		
		String sql = "CALL GetUserByAccount(:account);";
		
		Map<String, Object> map = new HashMap<>();
		map.put("account", account);
		
		List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());
		
		if(userList.size() > 0) {
			return userList.get(0);
		}else {
			return null;
		}
		
	}
	
	
}
