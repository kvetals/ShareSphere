package com.insart.traineeprogram.dao.springjdbc;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.insart.traineeprogram.dao.FileSystemObjectsDAO;
import com.insart.traineeprogram.model.FileSystemObject;

public class FileSystemObjectsDAOSpringJDBCImpl extends JdbcDaoSupport implements FileSystemObjectsDAO {

	@Override
	public void addFsObject(Integer objectTypeIdFk, Integer userIdFk, String fsObjectPath) {
		getJdbcTemplate().update(ADD_FS_OBJECT, new Object[]{objectTypeIdFk, userIdFk, fsObjectPath});
	}

	@Override
	public List<FileSystemObject> getFsObjects() {
		try{
			return getJdbcTemplate().query(GET_ALL_FS_OBJECTS, new BeanPropertyRowMapper<FileSystemObject>(FileSystemObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public List<FileSystemObject> getFsObjectsByUserId(Integer userId) {
		try{
			return getJdbcTemplate().query(GET_ALL_FS_OBJECTS_BY_USER_ID, new Object[]{userId}, new BeanPropertyRowMapper<FileSystemObject>(FileSystemObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public FileSystemObject getFsObjectById(Integer id) {
		try{
			return getJdbcTemplate().queryForObject(GET_FS_OBJECT_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<FileSystemObject>(FileSystemObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public List<FileSystemObject> getFsObjectsByName(String name) {
		try{
			return getJdbcTemplate().query(GET_FS_OBJECTS_BY_NAME, new Object[]{name}, new BeanPropertyRowMapper<FileSystemObject>(FileSystemObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public List<FileSystemObject> getRootFsObjectsByUserId(Integer userId){
		try{
			return getJdbcTemplate().query(GET_ROOT_FS_OBJECTS_BY_USER_ID, new Object []{userId}, new BeanPropertyRowMapper<FileSystemObject>(FileSystemObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public List<FileSystemObject> getFsObjectSiblings(Integer userId, Integer fsObjectId) {
		try{
			FileSystemObject fsObject = getFsObjectById(fsObjectId);
			System.out.println("founded userId = " + userId);
			System.out.println("founded fsObject = " + fsObject);
			System.out.println("and it's ParentFsObjectId = " + fsObject.getParentFsObjectId());
			if (fsObject.getParentFsObjectId() != null){
				System.out.println("entered != null");
				return getJdbcTemplate().query(GET_FS_OBJECT_SIBLINGS_BY_USER_ID_AND_PARENT_FS_OBJECT_ID, new Object []{userId, fsObject.getParentFsObjectId()}, new BeanPropertyRowMapper<FileSystemObject>(FileSystemObject.class));
			}else{
				System.out.println("entered == null");
				return getRootFsObjectsByUserId(userId);
			}
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public List<FileSystemObject> getFsObjectsChildrenByParentId(Integer parentFsObjectId){
		try{
			return getJdbcTemplate().query(GET_FS_OBJECTS_CHILDREN_BY_PARENT_ID, new Object []{parentFsObjectId}, new BeanPropertyRowMapper<FileSystemObject>(FileSystemObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public List<FileSystemObject> getAllLinkedFsObjectsByUserId(Integer userId) {
		try{
			return getJdbcTemplate().query(GET_ALL_LINKED_FS_OBJECTS_BY_USER_ID, new Object[]{userId}, new BeanPropertyRowMapper<FileSystemObject>(FileSystemObject.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public void deleteLinkByObjectId(Integer id) {
		getJdbcTemplate().update(DELETE_LINK_BY_OBJECT_ID, new Object[]{id});
	}

	@Override
	public void deleteLinkByObjectLink(String objectLink) {
		getJdbcTemplate().update(DELETE_LINK_BY_OBJECT_LINK, new Object[]{objectLink});
	}

	@Override
	public void deleteFsObjectById(int id) {
		getJdbcTemplate().update(DELETE_FS_OBJECT_BY_ID, new Object[]{id});

	}

	@Override
	public void deleteFsObjectByPath(String path) {
		getJdbcTemplate().update(DELETE_FS_OBJECT_BY_PATH, new Object[]{path});
	}

}
