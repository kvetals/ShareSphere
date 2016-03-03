package com.insart.traineeprogram.dao;

import java.util.ResourceBundle;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class InitDestroyDAOSpringJDBCImpl extends JdbcDaoSupport implements InitDestroyDAO {
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("dataBaseInitDestroy");
	
	@Override
	public void initDb() {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		jdbcTemplate.execute(resourceBundle.getString("CREATE_ROLES_TABLE"));
		jdbcTemplate.execute(resourceBundle.getString("CREATE_PRIVILEGES_TABLE"));
		jdbcTemplate.execute(resourceBundle.getString("CREATE_OBJECT_TYPES_TABLE"));
		jdbcTemplate.execute(resourceBundle.getString("CREATE_USERS_TABLE"));
		jdbcTemplate.execute(resourceBundle.getString("CREATE_FILE_SYSTEM_OBJECTS_TABLE"));
		jdbcTemplate.execute(resourceBundle.getString("CREATE_SHARED_OBJECTS_TABLE"));
	}

	@Override
	public void destroyDb() {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		jdbcTemplate.execute(resourceBundle.getString("DROP_SHARED_OBJECTS_TABLE"));
		jdbcTemplate.execute(resourceBundle.getString("DROP_FILE_SYSTEM_OBJECTS_TABLE"));
		jdbcTemplate.execute(resourceBundle.getString("DROP_USERS_TABLE"));
		jdbcTemplate.execute(resourceBundle.getString("DROP_OBJECT_TYPES_TABLE"));
		jdbcTemplate.execute(resourceBundle.getString("DROP_PRIVILEGES_TABLE"));
		jdbcTemplate.execute(resourceBundle.getString("DROP_ROLES_TABLE"));
	}

}
