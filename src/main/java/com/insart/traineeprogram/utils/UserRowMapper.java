package com.insart.traineeprogram.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insart.traineeprogram.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt("user_id"));
		user.setUserLogin(rs.getString("user_login"));
		user.setUserPassword(rs.getString("user_password"));
		user.setUserEmail(rs.getString("user_email"));
		user.setRoleId(rs.getInt("role_id"));
		return user;
	}

}
