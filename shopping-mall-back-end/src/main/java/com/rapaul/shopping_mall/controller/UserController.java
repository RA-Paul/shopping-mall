package com.rapaul.shopping_mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rapaul.shopping_mall.dto.UserLoginRequest;
import com.rapaul.shopping_mall.dto.UserRegisterRequest;
import com.rapaul.shopping_mall.model.User;
import com.rapaul.shopping_mall.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/users/login")
	public ResponseEntity<User> login(@RequestBody @Valid UserLoginRequest userLoginRequest){
		
		User user = userService.login(userLoginRequest);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
		
	}
	
	@PostMapping("/api/users/register")
	public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest){
		
		Integer userId = userService.register(userRegisterRequest);
		User user = userService.getUserById(userId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
		
	}
}
