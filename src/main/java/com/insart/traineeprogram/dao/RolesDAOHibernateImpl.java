package com.insart.traineeprogram.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.insart.traineeprogram.model.Role;
import com.insart.traineeprogram.utils.DaoHibernateUtils;

public class RolesDAOHibernateImpl implements RolesDAO {
	
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
		List<Role> list;
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			list = s.createCriteria(Role.class).list();
		}
		return list;
	}

	@Override
	public void addRole(String caption) {
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			Role role = new Role(caption);
			s.save(role);
		}
		
	}

	@Override
	public void addRoleByIndex(int index, String caption) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role getRoleById(Integer id) {
		Role role;
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			role = s.get(Role.class, id);
		}
		return role;
	}

	@Override
	public Role getRoleByCaption(String caption) {
		Role role;
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			Criteria criteria = s.createCriteria(Role.class);
			role = (Role)criteria.add(Restrictions.eq("roleCaption", caption)).uniqueResult();
		}
		return role;
	}

	@Override
	public void deleteRoleById(int index) {
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			Role role = s.get(Role.class, index);
			if (role != null){
				s.delete(role);
				s.flush();
			}
		}
	}

	@Override
	public void deleteRoleByCaption(String caption) {
		try(Session s = DaoHibernateUtils.getHibernateSession()){
			Criteria criteria = s.createCriteria(Role.class);
			Role role = (Role)criteria.add(Restrictions.eq("roleCaption", caption)).uniqueResult();
			if (role != null){
				s.delete(role);
				s.flush();
			}
		}
	}

}
