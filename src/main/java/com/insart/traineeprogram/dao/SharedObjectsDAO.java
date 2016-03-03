package com.insart.traineeprogram.dao;

import com.insart.traineeprogram.model.SharedObject;

import java.util.List;

/**
 * Created by Семья on 13.02.2016.
 */
public interface SharedObjectsDAO {

    String ADD_SHARED_OBJECT = "INSERT INTO shared_objects (object_id, user_id, privilege_id) VALUES (?, ?, ?)";

    String GET_ALL_SHARED_OBJECTS = "SELECT * FROM shared_objects";
    String GET_SHARED_OBJECT_BY_SHARED_OBJECT_ID = "SELECT * FROM shared_objects WHERE shared_object_id = ?";
    String GET_ALL_SHARED_OBJECTS_BY_USER_ID = "SELECT * FROM shared_objects WHERE user_id = ?";
    String GET_SHARED_OBJECTS_BY_OWNER_ID = "SELECT shared_objects.* FROM shared_objects, fs_objects WHERE shared_objects.object_id = fs_objects.fs_object_id and fs_objects.user_id = ?";
    String GET_SHARED_OBJECTS_BY_OBJECT_ID = "SELECT * FROM shared_objects WHERE object_id = ?";
    String GET_SHARED_OBJECT_BY_OBJECT_ID_AND_USER_ID = "SELECT * FROM shared_objects WHERE object_id = ?";
    String GET_SHARED_OBJECTS_FROM_OWNER_ID_TO_USER_ID = "SELECT shared_objects.* FROM shared_objects, fs_objects WHERE shared_objects.object_id = fs_objects.fs_object_id and fs_objects.user_id = ? AND shared_objects.user_id = ?";
    String GET_SHARED_OBJECTS_BY_OWNER_ID_FOR_USER_ID = "SELECT shared_objects.* \n" +
												        "FROM shared_objects \n" +
												        "JOIN file_system_objects \n" +
												        "ON shared_objects.object_id = file_system_objects.fs_object_id \n" +
												        "WHERE file_system_objects.user_id = ? AND shared_objects.user_id = ?";
    
    String UPDATE_SHARED_OBJECT = "UPDATE shared_objects SET user_id = ?, privilege_id = ? WHERE  shared_object_id = ?";

    String DELETE_SHARED_OBJECT_BY_SHARED_OBJECT_ID = "DELETE FROM shared_objects WHERE shared_object_id = ?";
    String DELETE_SHARED_OBJECTS_BY_OBJECT_ID = "DELETE FROM shared_objects WHERE object_id = ?"; //DELETE ALL SHARE FOR OBJECT
    String DELETE_SHARED_OBJECT_BY_OBJECT_ID_FOR_USER_ID = "DELETE FROM shared_objects WHERE object_id = ? AND user_id = ?";
    String DELETE_SHARED_OBJECTS_BY_OWNER_ID_FOR_USER_ID = "Delete shared_objects.* \n" +
                                                            "FROM shared_objects \n" +
                                                            "JOIN file_system_objects \n" +
                                                            "ON shared_objects.object_id = file_system_objects.fs_object_id \n" +
                                                            "WHERE file_system_objects.user_id = ? AND shared_objects.user_id = ?";

    public boolean isIdExists(Integer id);
    
    public boolean isObjectSharedToUser(Integer fsObjectId, Integer userId);

    public void addSharedObject(Integer objectId, Integer userId, Integer privilegeId );

    public List<SharedObject> getAllSharedObjects();

    public SharedObject getSharedObjectBySharedObjectId(Integer sharedObjectId);

    public List<SharedObject> getSharedObjectByUserId(Integer userId);

    public List<SharedObject> getSharedObjectsByOwnerId(Integer ownerId);

    public List<SharedObject> getSharedObjectsByObjectId(Integer objectId);
    
    public SharedObject getSharedObjectByObjectIdAndUserId(Integer objectId, Integer userId);

    public List<SharedObject> getAllSharedObjectsFromOwnerIdToUserId(Integer ownerId, Integer userId);
    
    public void updateSharedObject(SharedObject sharedObject);

    public void deleteSharedObjectBySharedObjectId(Integer sharedObjectId);

    public void deleteSharedObjectsByObjectId(Integer objectId);

    public void deleteSharedObjectByObjectIdForUserId(Integer objectId, Integer userId);

    public void deleteSharedObjectsByOwnerIdForUserId(Integer ownerId, Integer userId);

}
