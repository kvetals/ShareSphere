package com.insart.traineeprogram.dao.springjdbc;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.insart.traineeprogram.dao.SharedObjectsDAO;
import com.insart.traineeprogram.model.SharedObject;

public class SharedObjectsDAOSpringJDBCImpl extends JdbcDaoSupport implements SharedObjectsDAO {
	
	
	
	@Override
    public boolean isIdExists(Integer id){
		return getSharedObjectBySharedObjectId(id) != null;
	}
	
	@Override
    public boolean isObjectSharedToUser(Integer objectId, Integer userId){
    	return getSharedObjectByObjectIdAndUserId(objectId, userId) != null;
    }

	@Override
	public void addSharedObject(Integer objectId, Integer userId, Integer privilegeId) {
		getJdbcTemplate().update(ADD_SHARED_OBJECT, new Object[]{objectId, userId, privilegeId});
	}

	@Override
	public List<SharedObject> getAllSharedObjects() {
		try{
			return getJdbcTemplate().query(GET_ALL_SHARED_OBJECTS, new BeanPropertyRowMapper<SharedObject>(SharedObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public SharedObject getSharedObjectBySharedObjectId(Integer sharedObjectId) {
		try{
			return getJdbcTemplate().queryForObject(GET_SHARED_OBJECT_BY_SHARED_OBJECT_ID, new Object[]{sharedObjectId}, new BeanPropertyRowMapper<SharedObject>(SharedObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public List<SharedObject> getSharedObjectByUserId(Integer userId) {
		try{
			return getJdbcTemplate().query(GET_ALL_SHARED_OBJECTS_BY_USER_ID, new Object[]{userId}, new BeanPropertyRowMapper<SharedObject>(SharedObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public List<SharedObject> getSharedObjectsByOwnerId(Integer ownerId) {
		try{
			return getJdbcTemplate().query(GET_SHARED_OBJECTS_BY_OWNER_ID, new Object[]{ownerId}, new BeanPropertyRowMapper<SharedObject>(SharedObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public List<SharedObject> getSharedObjectsByObjectId(Integer objectId) {
		try{
			return getJdbcTemplate().query(GET_SHARED_OBJECTS_BY_OBJECT_ID, new Object[]{objectId}, new BeanPropertyRowMapper<SharedObject>(SharedObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public SharedObject getSharedObjectByObjectIdAndUserId(Integer objectId, Integer userId) {
		try{
			return getJdbcTemplate().queryForObject(GET_SHARED_OBJECT_BY_OBJECT_ID_AND_USER_ID, new Object[]{objectId, userId}, new BeanPropertyRowMapper<SharedObject>(SharedObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public List<SharedObject> getAllSharedObjectsFromOwnerIdToUserId(Integer ownerId, Integer userId) {
		try{
			return getJdbcTemplate().query(GET_SHARED_OBJECTS_FROM_OWNER_ID_TO_USER_ID, new Object[]{ownerId, userId}, new BeanPropertyRowMapper<SharedObject>(SharedObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public void updateSharedObject(SharedObject sharedObject) {
		getJdbcTemplate().update(UPDATE_SHARED_OBJECT, new Object[]{sharedObject.getUserId(), sharedObject.getPrivilegeId(), sharedObject.getSharedObjectId()});
	}

	@Override
	public void deleteSharedObjectBySharedObjectId(Integer sharedObjectId) {
		getJdbcTemplate().update(DELETE_SHARED_OBJECT_BY_SHARED_OBJECT_ID, new Object[]{sharedObjectId});
	}

	@Override
	public void deleteSharedObjectsByObjectId(Integer objectId) {
		getJdbcTemplate().update(DELETE_SHARED_OBJECTS_BY_OBJECT_ID, new Object[]{objectId});
	}

	@Override
	public void deleteSharedObjectByObjectIdForUserId(Integer objectId, Integer userId) {
		getJdbcTemplate().update(DELETE_SHARED_OBJECT_BY_OBJECT_ID_FOR_USER_ID, new Object[]{objectId, userId});
	}

	@Override
	public void deleteSharedObjectsByOwnerIdForUserId(Integer ownerId, Integer userId) {
		getJdbcTemplate().update(DELETE_SHARED_OBJECTS_BY_OWNER_ID_FOR_USER_ID, new Object[]{ownerId, userId});
	}

}
