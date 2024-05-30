package com.rapaul.shopping_mall.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import com.rapaul.shopping_mall.dao.MemberDao;
import com.rapaul.shopping_mall.dto.MemberLoginRequest;
import com.rapaul.shopping_mall.dto.MemberRegisterRequest;
import com.rapaul.shopping_mall.model.Member;
import com.rapaul.shopping_mall.service.MemberService;

@Component
public class MemberServiceImpl implements MemberService{
	
	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private MemberDao memberDao;
	
	
	@Override
	public Integer register(MemberRegisterRequest memberRegisterRequest) {
		
		// 檢查帳號是否重複
		Member member = memberDao.getMemberByAccount(memberRegisterRequest.getAccount());
		
		if(member != null) {
			log.warn("該 account {} 已經被註冊", memberRegisterRequest.getAccount());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		// 使用 MD5 生成密碼的雜湊值
		String hashedPassword = DigestUtils.md5DigestAsHex(memberRegisterRequest.getPassword().getBytes());
		memberRegisterRequest.setPassword(hashedPassword);
		
		// 創建帳號
		return memberDao.createMember(memberRegisterRequest);

	}



	@Override
	public Member getMemberById(Integer memberId) {
		return memberDao.getMemberById(memberId);
	}
	



	@Override
	public Member login(MemberLoginRequest memberLoginRequest) {
		
		Member member = memberDao.getMemberByAccount(memberLoginRequest.getAccount());
		
		// 檢查 member 是否存在
		if(member == null) {
			log.warn("該 account {} 尚未註冊", memberLoginRequest.getAccount());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		// 使用 MD5 生成密碼的雜湊值
		String hashedPassword = DigestUtils.md5DigestAsHex(memberLoginRequest.getPassword().getBytes());
		
		// 比較密碼
		if(member.getPassword().equals(hashedPassword)) {
			return member;
		}else {
			log.warn("account {} 的密碼不正確", memberLoginRequest.getAccount());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		
	}

}
