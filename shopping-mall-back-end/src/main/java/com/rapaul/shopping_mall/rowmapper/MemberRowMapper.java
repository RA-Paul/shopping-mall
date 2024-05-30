package com.rapaul.shopping_mall.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rapaul.shopping_mall.model.Member;

public class MemberRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Member member = new Member();
		member.setMemberId(rs.getInt("member_id"));
		member.setAccount(rs.getString("account"));
		member.setPassword(rs.getString("password"));
		member.setCreatedDate(rs.getDate("created_date"));
		member.setLastModifiedDate(rs.getDate("last_modified_date"));
		
		return member;
		
	}

}
