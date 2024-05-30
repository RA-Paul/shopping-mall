package com.rapaul.shopping_mall.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.rapaul.shopping_mall.dao.MemberDao;
import com.rapaul.shopping_mall.dto.MemberRegisterRequest;
import com.rapaul.shopping_mall.model.Member;
import com.rapaul.shopping_mall.rowmapper.MemberRowMapper;


@Component
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Override
	public Integer createMember(MemberRegisterRequest memberRegisterRequest) {
		String sql = "INSERT member(member_id, account, password, created_date, last_modified_date)"
				+ " VALUES (null, :account , :password , :createdDate , :lastModifiedDate );";
		
		Map<String, Object> map = new HashMap<>();
		map.put("account", memberRegisterRequest.getAccount());
		map.put("password", memberRegisterRequest.getPassword());
		
		Date now = new Date();
		map.put("createdDate", now);
		map.put("lastModifiedDate", now);
		
		KeyHolder keyholder = new GeneratedKeyHolder();
		
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyholder);
		
		int memberId = keyholder.getKey().intValue();
		
		return memberId;
	}

	@Override
	public Member getMemberById(Integer memberId) {
		String sql = "SELECT member_id ,account, password, created_date, last_modified_date FROM member WHERE member_id = :memberId ;";
		
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		
		List<Member> memberList = namedParameterJdbcTemplate.query(sql, map, new MemberRowMapper());
		
		if(memberList.size() > 0) {
			return memberList.get(0);
		}else {
			return null;
		}
	}

	@Override
	public Member getMemberByAccount(String account) {
		String sql = "SELECT member_id ,account, password, created_date, last_modified_date FROM member WHERE account = :account ;";
		
		Map<String, Object> map = new HashMap<>();
		map.put("account", account);
		
		List<Member> memberList = namedParameterJdbcTemplate.query(sql, map, new MemberRowMapper());
		
		if(memberList.size() > 0) {
			return memberList.get(0);
		}else {
			return null;
		}
	}

}
