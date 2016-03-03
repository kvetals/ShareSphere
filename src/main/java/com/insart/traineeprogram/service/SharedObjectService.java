package com.insart.traineeprogram.service;

import com.insart.traineeprogram.dao.SharedObjectsDAO;
import com.insart.traineeprogram.model.SharedObject;

public class SharedObjectService {
	
	private SharedObjectsDAO sharedObjectsDAO;
	
	public boolean addNewSharedObject(Integer fsObjectId, Integer userId, Integer privilegeId){
		boolean result = false;
		if (!sharedObjectsDAO.isObjectSharedToUser(fsObjectId, userId)){
			sharedObjectsDAO.addSharedObject(fsObjectId, userId, privilegeId);
			result = true;
		}
		return result;
	}
	
	public boolean changeAccessPrivilegeToObjectForUser(Integer fsObjectId, Integer userId, Integer privilegeId){
		boolean result = false;
		SharedObject sharedObject;
		if((sharedObject = sharedObjectsDAO.getSharedObjectByObjectIdAndUserId(fsObjectId, userId)) != null){
			sharedObject.setPrivilegeId(privilegeId);
			sharedObjectsDAO.updateSharedObject(sharedObject);
			result = true;
		}
		return result;
	}
	
	public boolean deleteAnyShareForObjectByObjectId(int fsObjectId){
		boolean result = false;
		if (sharedObjectsDAO.getSharedObjectsByObjectId(fsObjectId) != null){
			sharedObjectsDAO.deleteSharedObjectsByObjectId(fsObjectId);
			result = true;
		}
		return result;
	}
	
	public boolean deleteAnySharedObjectsFromOwnerIdToUserId(Integer ownerId, Integer userId){
		boolean result = false;
		if (sharedObjectsDAO.getAllSharedObjectsFromOwnerIdToUserId(ownerId, userId) != null){
			sharedObjectsDAO.deleteSharedObjectsByOwnerIdForUserId(ownerId, userId);
			result = true;
		}
		return result;
	}

}
