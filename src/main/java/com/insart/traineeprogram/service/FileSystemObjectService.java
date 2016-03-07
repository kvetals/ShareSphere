package com.insart.traineeprogram.service;

import java.util.List;

import com.insart.traineeprogram.dao.FileSystemObjectsDAO;
import com.insart.traineeprogram.model.FileSystemObject;

public class FileSystemObjectService {
	
	private FileSystemObjectsDAO fileSystemObjectsDAO;
	
	public boolean ifUserIsOwner(Integer userId, Integer objectId){
		return userId == fileSystemObjectsDAO.getFsObjectById(objectId).getUserId();
	}

	public FileSystemObjectsDAO getFileSystemObjectsDAO() {
		return fileSystemObjectsDAO;
	}

	public void setFileSystemObjectsDAO(FileSystemObjectsDAO fileSystemObjectsDAO) {
		this.fileSystemObjectsDAO = fileSystemObjectsDAO;
	}
	
	public List<FileSystemObject> getFsObjectsListOfUser(Integer userId){
		List<FileSystemObject> list = null;
		list = fileSystemObjectsDAO.getFsObjectsByUserId(userId);
		return list;
	}
	
	public List<FileSystemObject> getRootFsObjectsOfUser(Integer userId){
		List<FileSystemObject> list = null;
		list = fileSystemObjectsDAO.getRootFsObjectsByUserId(userId);
		return list;
	}
	
	public List<FileSystemObject> getFsObjectsChildren(Integer parentId){
		List<FileSystemObject> list = null;
		list = fileSystemObjectsDAO.getFsObjectsChildrenByParentId(parentId);
		return list;
	}
	
	public List<FileSystemObject> getSiblings(Integer userId, Integer fsObjectId){
		List<FileSystemObject> list = null;
		if(fsObjectId != null){
			list = fileSystemObjectsDAO.getFsObjectSiblings(userId, fsObjectId);
		}else{
			getRootFsObjectsOfUser(userId);
		}
		return list;
	}
	
	public void addFsObjectToDB(Integer objectTypeId, Integer userId, String fsObjectPath){
		fileSystemObjectsDAO.addFsObject(objectTypeId, userId, fsObjectPath);
	}
	
	public void deleteFsObjectByIdFromDB(Integer id){
		fileSystemObjectsDAO.deleteFsObjectById(id);
	}

}
