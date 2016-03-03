package com.insart.traineeprogram.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.insart.traineeprogram.model.Privilege;

public class PrivilegesDAOSpringJDBCImpl extends JdbcDaoSupport implements PrivilegesDAO {
	
	@Override
	public boolean isIdExists(int id){
		return getPrivilegeById(id) != null;
	}
    
	@Override
    public boolean isCaptionExists(String caption){
		return getPrivilegeByCaption(caption) != null;
    }

	@Override
	public List<Privilege> getPrivileges() {
		try{
			return getJdbcTemplate().query(GET_ALL_PRIVILEGES, new BeanPropertyRowMapper<Privilege>(Privilege.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public void addPrivilege(String caption) {
		getJdbcTemplate().update(ADD_PRIVILEGE, new Object[]{caption});
	}

	@Override
	public void addPrivilegeByIndex(int index, String caption) {
		getJdbcTemplate().update(ADD_PRIVILEGE_BY_INDEX, new Object[]{index, caption});
	}

	@Override
	public Privilege getPrivilegeById(Integer id) {
		try{
			return getJdbcTemplate().queryForObject(GET_PRIVILEGE_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<Privilege>(Privilege.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public Privilege getPrivilegeByCaption(String caption) {
		try{
			return getJdbcTemplate().queryForObject(GET_PRIVILEGE_BY_CAPTION, new Object[]{caption}, new BeanPropertyRowMapper<Privilege>(Privilege.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public void deletePrivilegeById(int id) {
		getJdbcTemplate().update(DELETE_PRIVILEGE_BY_ID, new Object[]{id});
	}

	@Override
	public void deletePrivilegeByCaption(String caption) {
		getJdbcTemplate().update(DELETE_PRIVILEGE_BY_CAPTION, new Object[]{caption});
	}

}
