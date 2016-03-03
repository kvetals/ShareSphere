package com.insart.traineeprogram.service;

import com.insart.traineeprogram.dao.RolesDAO;

public class RoleService {
	
	private RolesDAO rolesDAO;
	
	public boolean addNewRole(String caption){
		boolean result = false;
		if (!rolesDAO.isCaptionExists(caption.toLowerCase())){
			rolesDAO.addRole(caption.toLowerCase());
			result = true;
		}
		return result;
	}
	
	public boolean addNewRoleById(int id, String caption){
		boolean result = false;
		if (!rolesDAO.isIdExists(id) && !rolesDAO.isCaptionExists(caption.toLowerCase())){
			rolesDAO.addRoleByIndex(id, caption.toLowerCase());
			result = true;
		}
		return result;
	}
	
	public boolean deleteRoleById(int id){
		boolean result = false;
		if (rolesDAO.isIdExists(id)){
			rolesDAO.deleteRoleById(id);
			result = true;
		}
		return result;
	}
	
	public boolean deleteRoleByCaption(String caption){
		boolean result = false;
		if (rolesDAO.isCaptionExists(caption.toLowerCase())){
			rolesDAO.deleteRoleByCaption(caption.toLowerCase());
			result = true;
		}
		return result;
	}
	
}
