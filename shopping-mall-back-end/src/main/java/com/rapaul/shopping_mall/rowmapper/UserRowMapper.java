package com.rapaul.shopping_mall.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rapaul.shopping_mall.model.User;

public class UserRowMapper  implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		
		user.setUserId(rs.getInt("user_id"));
		user.setAccount(rs.getString("account"));
		user.setPassword(rs.getString("password"));
		user.setCreatedDate(rs.getDate("created_date"));
		user.setLastModifiedDate(rs.getDate("last_modified_date"));
		
		return user;
		
	}

}
