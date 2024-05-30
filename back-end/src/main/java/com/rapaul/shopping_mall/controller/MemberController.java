package com.rapaul.shopping_mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rapaul.shopping_mall.dto.MemberLoginRequest;
import com.rapaul.shopping_mall.dto.MemberLoginResponse;
import com.rapaul.shopping_mall.dto.MemberRegisterRequest;
import com.rapaul.shopping_mall.model.Member;
import com.rapaul.shopping_mall.service.MemberService;

import jakarta.validation.Valid;


@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/api/members/login")
	public ResponseEntity<MemberLoginResponse> login(@RequestBody @Valid MemberLoginRequest memberLoginRequest){
		
		MemberLoginResponse memberLoginResponse = memberService.login(memberLoginRequest);
		
		return ResponseEntity.status(HttpStatus.OK).body(memberLoginResponse);
		
	}
	
	@PostMapping("/api/members/register")
	public ResponseEntity<Member> register(@RequestBody @Valid MemberRegisterRequest memberRegisterRequest){
		
		Integer memberId = memberService.register(memberRegisterRequest);
		Member member = memberService.getMemberById(memberId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(member);
		
	}
}
