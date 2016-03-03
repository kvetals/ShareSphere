package com.insart.traineeprogram.service;

import com.insart.traineeprogram.dao.PrivilegesDAO;

public class PrivilegeService {
private PrivilegesDAO privilegesDAO;
	
	public boolean addNewPrivilege(String caption){
		boolean result = false;
		if (!privilegesDAO.isCaptionExists(caption.toLowerCase())){
			privilegesDAO.addPrivilege(caption.toLowerCase());
			result = true;
		}
		return result;
	}
	
	public boolean addNewPrivilegeById(int id, String caption){
		boolean result = false;
		if (!privilegesDAO.isIdExists(id) && !privilegesDAO.isCaptionExists(caption.toLowerCase())){
			privilegesDAO.addPrivilegeByIndex(id, caption.toLowerCase());
			result = true;
		}
		return result;
	}
	
	public boolean deletePrivilegeById(int id){
		boolean result = false;
		if (privilegesDAO.isIdExists(id)){
			privilegesDAO.deletePrivilegeById(id);
			result = true;
		}
		return result;
	}
	
	public boolean deletePrivilegeByCaption(String caption){
		boolean result = false;
		if (privilegesDAO.isCaptionExists(caption.toLowerCase())){
			privilegesDAO.deletePrivilegeByCaption(caption.toLowerCase());
			result = true;
		}
		return result;
	}

}
