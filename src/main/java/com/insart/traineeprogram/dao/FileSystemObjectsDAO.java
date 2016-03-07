package com.insart.traineeprogram.dao;

import com.insart.traineeprogram.model.FileSystemObject;

import java.util.List;

/**
 * Created by Семья on 13.02.2016.
 */
public interface FileSystemObjectsDAO {

    String ADD_FS_OBJECT = "INSERT INTO file_system_objects (object_type_id, user_id, fs_object_path ) VALUES (?, ?, ?)";

    String GET_ALL_FS_OBJECTS = "SELECT * FROM file_system_objects";
    String GET_ALL_FS_OBJECTS_BY_USER_ID = "SELECT * FROM file_system_objects WHERE user_id = ?";
    String GET_FS_OBJECT_BY_ID = "SELECT * FROM file_system_objects WHERE fs_object_id = ?";
    String GET_FS_OBJECTS_BY_PATH = "SELECT * FROM file_system_objects WHERE fs_object_path = ?";
    String GET_FS_OBJECTS_BY_NAME = "SELECT * FROM file_system_objects WHERE fs_object_name LIKE ?";
    String GET_FS_OBJECTS_CHILDREN_BY_PARENT_ID = "SELECT * FROM file_system_objects WHERE parent_fs_object_id = ?";
    String GET_FS_OBJECT_SIBLINGS_BY_USER_ID_AND_PARENT_FS_OBJECT_ID = "SELECT * FROM file_system_objects WHERE user_id = ? and parent_fs_object_id = ?";
    String GET_ROOT_FS_OBJECTS_BY_USER_ID = "SELECT * FROM file_system_objects WHERE user_id = ? and parent_fs_object_id is null";
    String GET_ALL_LINKED_FS_OBJECTS_BY_USER_ID = "SELECT * FROM file_system_objects WHERE fs_object_dl_link is not null and user_id = ?";
    String DELETE_LINK_BY_OBJECT_ID = "UPDATE file_system_objects SET fs_object_dl_link = null WHERE fs_object_id = ?";
    String DELETE_LINK_BY_OBJECT_LINK = "UPDATE file_system_objects SET fs_object_dl_link = null WHERE fs_object_dl_link = ?";

    String DELETE_FS_OBJECT_BY_ID = "DELETE FROM file_system_objects WHERE fs_object_id = ?";
    String DELETE_FS_OBJECT_BY_PATH = "DELETE FROM file_system_objects WHERE fs_object_path = ?";


//    UPDATE_FS_OBJECT_BY_ID = "";
//            UPDATE_FS_OBJECT_BY_PATH ="";

    public void addFsObject(Integer objectTypeId, Integer userId, String fsObjectPath);

    public List<FileSystemObject> getFsObjects();

    public List<FileSystemObject> getFsObjectsByUserId(Integer userId);

    public FileSystemObject getFsObjectById(Integer id);

    public List<FileSystemObject> getFsObjectsByName(String name);
    
    public List<FileSystemObject> getRootFsObjectsByUserId(Integer userId);
    
    public List<FileSystemObject> getFsObjectSiblings(Integer userId, Integer fsObjectId);
    
    public List<FileSystemObject> getFsObjectsChildrenByParentId(Integer parentFsObjectId);

    public List<FileSystemObject> getAllLinkedFsObjectsByUserId(Integer userId);

    public void deleteLinkByObjectId(Integer id);

    public void deleteLinkByObjectLink(String objectLink);

    public void deleteFsObjectById(int id);

    public void deleteFsObjectByPath(String path);


}
