package com.insart.traineeprogram.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.insart.traineeprogram.model.Role;

public class RolesDAOSpringJDBCImpl extends JdbcDaoSupport implements RolesDAO {
	
	@Override
	public boolean isIdExists(int id){
		return getRoleById(id) != null;
	}
    
	@Override
    public boolean isCaptionExists(String caption){
		return getRoleByCaption(caption) != null;
	}

	@Override
	public List<Role> getRoles() {
		try{
			return getJdbcTemplate().query(GET_ALL_ROLES, new BeanPropertyRowMapper<Role>(Role.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public void addRole(String caption) {
		getJdbcTemplate().update(ADD_ROLE, new Object[] {caption});
	}

	@Override
	public void addRoleByIndex(int index, String caption) {
		getJdbcTemplate().update(ADD_ROLE_BY_INDEX, new Object[] {index, caption});

	}

	@Override
	public Role getRoleById(Integer id) {
		try{
			return getJdbcTemplate().queryForObject(GET_ROLE_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<Role>(Role.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public Role getRoleByCaption(String caption) {
		try{
			return getJdbcTemplate().queryForObject(GET_ROLE_BY_ID, new Object[]{caption}, new BeanPropertyRowMapper<Role>(Role.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public void deleteRoleById(int id) {
		getJdbcTemplate().update(DELETE_ROLE_BY_ID, new Object[] {id});

	}

	@Override
	public void deleteRoleByCaption(String caption) {
		getJdbcTemplate().update(DELETE_ROLE_BY_CAPTION, new Object[] {caption});

	}

}
