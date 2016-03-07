package com.insart.traineeprogram.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.insart.traineeprogram.model.FileSystemObject;
import com.insart.traineeprogram.service.FileSystemObjectService;
import com.insart.traineeprogram.service.UserService;
import com.insart.traineeprogram.utils.UserPath;

@Controller
public class FileSystemObjectsController {
	
	@Autowired
	FileSystemObjectService fileSystemObjectService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/getFileList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FileSystemObject> getFileList(HttpSession session){
		String userLogin = session.getAttribute("userLogin").toString();
		Integer userId = userService.getUserIdByUserLogin(userLogin);
		return fileSystemObjectService.getFsObjectsListOfUser(userId);
	}
	
	@RequestMapping(value = "/fsObjects/getRoot", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FileSystemObject> getRootFileList(HttpSession session){
		String userLogin = session.getAttribute("userLogin").toString();
		Integer userId = userService.getUserIdByUserLogin(userLogin);
		return fileSystemObjectService.getRootFsObjectsOfUser(userId);
	}
	
	@RequestMapping(value = "/fsObject/oneLayerUp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FileSystemObject> goOneLayerHigher(HttpSession session){
		Integer fsObjectId = ((UserPath)session.getAttribute("userPath")).getLastPoint();
		System.out.println("Integer from userPath = " + fsObjectId);
		if (fsObjectId == null){
			System.out.println("returning getRootFileList coz of fsObjectId == null");
			return getRootFileList(session);
		}
		String userLogin = session.getAttribute("userLogin").toString();
		Integer userId = userService.getUserIdByUserLogin(userLogin);
		return fileSystemObjectService.getSiblings(userId, fsObjectId);
	}
	@RequestMapping(value = "/fsObject/remove/{fsObjectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FileSystemObject> removeFsObject(HttpSession session, @PathVariable int fsObjectId){
		String userLogin = session.getAttribute("userLogin").toString();
		Integer userId = userService.getUserIdByUserLogin(userLogin);
		if (fileSystemObjectService.ifUserIsOwner(userId, fsObjectId)){
			fileSystemObjectService.deleteFsObjectByIdFromDB(fsObjectId);
		}
		return getFileList(session);
	}
	
	@RequestMapping(value = "/fsObject/getChildren/{parentFsObjectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FileSystemObject> getChildrenOfFsObject(HttpSession session, @PathVariable int parentFsObjectId){
//		String userLogin = session.getAttribute("userLogin").toString();
		System.out.println("userPath before = [ " + parentFsObjectId + " ]");
		System.out.println("putting to userPath id = " + parentFsObjectId);
		((UserPath)session.getAttribute("userPath")).addPoint(parentFsObjectId);
		System.out.println("userPath after = [ " + parentFsObjectId + " ]");
		return fileSystemObjectService.getFsObjectsChildren(parentFsObjectId);
	}
	
	@RequestMapping(value = "/fsObject/getPreview/{fsObjectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<FileSystemObject> getPreviewOfFsObject(HttpSession session, @PathVariable int fsObjectId){
		String userLogin = session.getAttribute("userLogin").toString();
		fileSystemObjectService.deleteFsObjectByIdFromDB(fsObjectId);
		return getFileList(session);
	}

}
