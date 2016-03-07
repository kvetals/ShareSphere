package com.insart.traineeprogram.dao.springjdbc;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.insart.traineeprogram.dao.UsersDAO;
import com.insart.traineeprogram.model.User;
//import com.insart.traineeprogram.utils.UserRowMapper;

public class UsersDAOSpringJDBCImpl extends JdbcDaoSupport implements UsersDAO {

	
	@Override
	public boolean isExist(String userLogin) {
		try{
			return getJdbcTemplate().queryForObject(GET_USER_BY_LOGIN, new Object[]{userLogin}, new BeanPropertyRowMapper<User>(User.class)) != null;
		}catch(EmptyResultDataAccessException e){
			return false;
		}
	}

	@Override
	public void addUser(User user) {
		getJdbcTemplate().update(CREATE_NEW_USER, new Object[] {user.getUserLogin(), user.getUserPassword(), user.getUserEmail(), user.getRoleId()});
	}
	
	@Override
	public User getUserById(int index) {
		try{
			return getJdbcTemplate().queryForObject(GET_USER_BY_ID, new Object[]{index}, new BeanPropertyRowMapper<User>(User.class)); //UserRowMapper());
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public User getUserByLogin(String userLogin) {
		try{
			return getJdbcTemplate().queryForObject(GET_USER_BY_LOGIN, new Object[]{userLogin}, new BeanPropertyRowMapper<User>(User.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public List<User> getAllUsers() {
		try{
			return getJdbcTemplate().query(GET_ALL_USERS, new BeanPropertyRowMapper<User>(User.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		try{
			return getJdbcTemplate().queryForObject(GET_USER_BY_EMAIL, new Object[]{email}, new BeanPropertyRowMapper<User>(User.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public User getUserByLoginAndPassword(String login, String password) {
		try{
			System.out.println("SpringJDBCImplementation is working now");
			return getJdbcTemplate().queryForObject(GET_USER_BY_LOGIN_AND_PASSWORD, new Object[]{login, password}, new BeanPropertyRowMapper<User>(User.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public List<User> getUsersByRoleCaption(String caption) {
		try{
			return getJdbcTemplate().query(GET_USERS_BY_ROLE_CAPTION, new Object[]{caption}, new BeanPropertyRowMapper<User>(User.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public void changePasswordByUserId(String password, Integer userId) {
		getJdbcTemplate().update(UPDATE_USER_PASSWORD_BY_ID, new Object[] {password, userId});
	}

	@Override
	public void deleteUserById(Integer id) {
		getJdbcTemplate().update(DELETE_USER_BY_ID, new Object[] {id});
	}

	@Override
	public void deleteUserByLogin(String login) {
		getJdbcTemplate().update(DELETE_USER_BY_LOGIN, new Object[] {login});
	}

}
