package com.insart.traineeprogram.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.insart.traineeprogram.model.ObjectType;

public class ObjectTypesDAOSpringJDBCImpl extends JdbcDaoSupport implements ObjectTypesDAO {
	
	@Override
	public boolean isIdExists(int id){
		return getObjectTypeById(id) != null;
	}
    
	@Override
    public boolean isCaptionExists(String caption){
		return getObjectTypeByCaption(caption) != null;
    }

	@Override
	public List<ObjectType> getObjectTypes() {
		try{
			return getJdbcTemplate().query(GET_ALL_OBJECT_TYPES, new BeanPropertyRowMapper<ObjectType>(ObjectType.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public void addObjectType(String caption) {
		getJdbcTemplate().update(ADD_OBJECT_TYPE, new Object[]{caption});
	}

	@Override
	public void addObjectTypeByIndex(int index, String caption) {
		getJdbcTemplate().update(ADD_OBJECT_TYPE_BY_INDEX, new Object[]{index, caption});
	}

	@Override
	public ObjectType getObjectTypeById(Integer id) {
		try{
			return getJdbcTemplate().queryForObject(GET_OBJECT_TYPE_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<ObjectType>(ObjectType.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public ObjectType getObjectTypeByCaption(String caption) {
		try{
			return getJdbcTemplate().queryForObject(GET_OBJECT_TYPE_BY_CAPTION, new Object[]{caption}, new BeanPropertyRowMapper<ObjectType>(ObjectType.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public void deleteObjectTypeById(int id) {
		getJdbcTemplate().update(DELETE_OBJECT_TYPE_BY_ID, new Object[]{id});
	}

	@Override
	public void deleteObjectTypeByCaption(String caption) {
		getJdbcTemplate().update(DELETE_OBJECT_TYPE_BY_CAPTION, new Object[]{caption});
	}

}
