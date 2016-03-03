package com.insart.traineeprogram.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.insart.traineeprogram.model.Role;
import com.insart.traineeprogram.model.User;
import com.insart.traineeprogram.utils.DaoHibernateUtils;

public class UsersDAOHibernateImpl implements UsersDAO {

	@Override
	public boolean isExist(String userLogin) {
		User user;
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			Criteria criteria = s.createCriteria(User.class);
			user = (User)criteria.add(Restrictions.eq("userLogin", userLogin)).uniqueResult();
		}
		return user != null;
	}

	@Override
	public void addUser(User user) {
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			Role roleUser = (Role) s.load(Role.class, user.getRoleId());
	        user.setRole(roleUser);
	        roleUser.getUserSet().add(user);
			s.save(user);
		}
	}

	@Override
	public void deleteUserById(Integer id) {
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			User user = s.load(User.class, id);
			System.out.println("User before deleting : " + user);
			if (user != null){
				System.out.println("User before deleting inside IF : " + user);
				s.delete(user);
				System.out.println("User after deleting : " + user);
				s.flush();
			}
		}
	}

	@Override
	public void deleteUserByLogin(String login) {
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			Criteria criteria = s.createCriteria(User.class);
			User user = (User)criteria.add(Restrictions.eq("userLogin", login)).uniqueResult();
			if (user != null){
				s.delete(user);
				s.flush();
			}
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list;
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			list = s.createCriteria(User.class).list();
		}
		return list;
	}

	@Override
	public User getUserById(int index) {
		User user;
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			user = s.get(User.class, index);
		}
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user;
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			Criteria criteria = s.createCriteria(User.class);
			user = (User)criteria.add(Restrictions.eq("userEmail", email)).uniqueResult();
		}
		return user;
	}

	@Override
	public User getUserByLoginAndPassword(String login, String password) {
		User user;
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			System.out.println("HibernateImplementation is working now");
			Criteria criteria = s.createCriteria(User.class);
			user = (User)criteria.add(Restrictions.eq("userLogin", login)).add(Restrictions.eq("userPassword", password)).uniqueResult();
		}
		return user;
	}

	@Override
	public List<User> getUsersByRoleCaption(String caption) {
		List<User> list;
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			RolesDAO rolesDao = new RolesDAOHibernateImpl();
			list = s.createCriteria(User.class).add(Restrictions.eq("role", rolesDao.getRoleByCaption(caption))).list();
		}
		return list;
	}

	@Override
	public void changePasswordByUserId(String password, Integer userId) {
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			Criteria criteria = s.createCriteria(User.class);
			User user = (User)criteria.add(Restrictions.eq("userId", userId)).uniqueResult();
			user.setUserPassword(password);
			s.saveOrUpdate(user);
			s.flush();
		}
		
	}

}
