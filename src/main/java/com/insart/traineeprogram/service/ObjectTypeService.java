package com.insart.traineeprogram.service;

import com.insart.traineeprogram.dao.ObjectTypesDAO;

public class ObjectTypeService {
	
	ObjectTypesDAO objectTypesDAO;
	
	public boolean addNewObjectType(String caption){
		boolean result = false;
		if (!objectTypesDAO.isCaptionExists(caption.toLowerCase())){
			objectTypesDAO.addObjectType(caption.toLowerCase());
			result = true;
		}
		return result;
	}
	
	public boolean addNewObjectTypeById(int id, String caption){
		boolean result = false;
		if (!objectTypesDAO.isIdExists(id) && !objectTypesDAO.isCaptionExists(caption.toLowerCase())){
			objectTypesDAO.addObjectTypeByIndex(id, caption.toLowerCase());
			result = true;
		}
		return result;
	}
	
	public boolean deleteObjectTypeById(int id){
		boolean result = false;
		if (objectTypesDAO.isIdExists(id)){
			objectTypesDAO.deleteObjectTypeById(id);
			result = true;
		}
		return result;
	}
	
	public boolean deleteObjectTypeByCaption(String caption){
		boolean result = false;
		if (objectTypesDAO.isCaptionExists(caption.toLowerCase())){
			objectTypesDAO.deleteObjectTypeByCaption(caption.toLowerCase());
			result = true;
		}
		return result;
	}

}
