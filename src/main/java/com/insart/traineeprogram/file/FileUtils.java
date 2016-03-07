package com.insart.traineeprogram.file;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import com.insart.traineeprogram.model.User;

public class FileUtils {
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("dataBase");
	
	private static Path rootDirectory = Paths.get(resourceBundle.getString("ROOT_STORAGE_PATH"));
	
	private static Path userPathResolver(User user){
		Path resolvedPath = null;
		return resolvedPath;
	}
	
	public static void saveFile(){}
	
	public static void renameFile(){}
	
	public static void moveFile(){}
	
	public static void deleteFile(){}

}
