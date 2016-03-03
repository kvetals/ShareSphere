package com.insart.traineeprogram.dao;

import com.insart.traineeprogram.model.SharedObject;
import com.insart.traineeprogram.utils.MyDbConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.insart.traineeprogram.utils.DaoUtils.*;

/**
 * Created by Семья on 14.02.2016.
 */
public class SharedObjectsDAOImpl implements SharedObjectsDAO {

    Logger logger = LogManager.getLogger(this.getClass());
    
    @Override
    public boolean isIdExists(Integer id){
		return getSharedObjectBySharedObjectId(id) != null;
	}
    
    @Override
    public boolean isObjectSharedToUser(Integer objectId, Integer userId){
    	return getSharedObjectByObjectIdAndUserId(objectId, userId) != null;
    }

    @Override
    public void addSharedObject(Integer objectId, Integer userId, Integer privilegeId) {
        try(Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, ADD_SHARED_OBJECT, "" + objectId, "" + userId, "" + privilegeId);
        }catch (Exception ignore){/*IGNORE*/}
    }

    @Override
    public List<SharedObject> getAllSharedObjects() {
        List<SharedObject> list = new ArrayList<>();
        try(Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_ALL_SHARED_OBJECTS);
            list = parseResultSet(resultSet, list, SharedObject.class);
        }catch (Exception ignore){/*IGNORE*/}
        return list;
    }

    @Override
    public SharedObject getSharedObjectBySharedObjectId(Integer sharedObjectId) {
        SharedObject sharedObject = null;
        try(Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_SHARED_OBJECT_BY_SHARED_OBJECT_ID, "" + sharedObjectId);
            sharedObject = parseResultSet(resultSet, SharedObject.class);
        }catch (Exception ignore){/*IGNORE*/}
        return sharedObject;
    }

    @Override
    public List<SharedObject> getSharedObjectByUserId(Integer userId) {
        List<SharedObject> list = new ArrayList<>();
        try(Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_ALL_SHARED_OBJECTS_BY_USER_ID, "" + userId);
            list = parseResultSet(resultSet, list, SharedObject.class);
        }catch (Exception ignore){/*IGNORE*/}
        return list;
    }

    @Override
    public List<SharedObject> getSharedObjectsByOwnerId(Integer ownerId) {
        List<SharedObject> list = new ArrayList<>();
        try(Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_SHARED_OBJECTS_BY_OWNER_ID, "" + ownerId);
            list = parseResultSet(resultSet, list, SharedObject.class);
        }catch (Exception ignore){/*IGNORE*/}
        return list;
    }

    @Override
    public List<SharedObject> getSharedObjectsByObjectId(Integer objectId) {
        List<SharedObject> list = new ArrayList<>();
        try(Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_SHARED_OBJECTS_BY_OBJECT_ID, "" + objectId);
            list = parseResultSet(resultSet, list, SharedObject.class);
        }catch (Exception ignore){/*IGNORE*/}
        return list;
    }
    
    @Override
    public SharedObject getSharedObjectByObjectIdAndUserId(Integer objectId, Integer userId){
    	SharedObject sharedObject = null;
	    try(Connection connection = MyDbConnection.getConnection()) {
	        ResultSet resultSet = executeQueryPreparedStatement(connection, GET_SHARED_OBJECT_BY_OBJECT_ID_AND_USER_ID, "" + objectId, "" + userId);
	        sharedObject = parseResultSet(resultSet, SharedObject.class);
	    }catch (Exception ignore){/*IGNORE*/}
	    return sharedObject;
    }

    @Override
    public List<SharedObject> getAllSharedObjectsFromOwnerIdToUserId(Integer ownerId, Integer userId) {
        List<SharedObject> list = new ArrayList<>();
        try(Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_SHARED_OBJECTS_FROM_OWNER_ID_TO_USER_ID, "" + ownerId, "" + userId);
            list = parseResultSet(resultSet, list, SharedObject.class);
        }catch (Exception ignore){/*IGNORE*/}
        return list;
    }
    
    
    @Override
    public void updateSharedObject(SharedObject sharedObject){
    	try(Connection connection = MyDbConnection.getConnection()) {
    		executePreparedStatement(connection, UPDATE_SHARED_OBJECT, "" + sharedObject.getUserId(), "" + sharedObject.getPrivilegeId(), "" + sharedObject.getSharedObjectId());
    	}catch (Exception ignore){/*IGNORE*/}
    }

    @Override
    public void deleteSharedObjectBySharedObjectId(Integer sharedObjectId) {
        try(Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, DELETE_SHARED_OBJECT_BY_SHARED_OBJECT_ID, "" + sharedObjectId);
        }catch (Exception ignore){/*IGNORE*/}
    }

    @Override
    public void deleteSharedObjectsByObjectId(Integer objectId) {
        try(Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, DELETE_SHARED_OBJECTS_BY_OBJECT_ID, "" + objectId);
        }catch (Exception ignore){/*IGNORE*/}
    }

    @Override
    public void deleteSharedObjectByObjectIdForUserId(Integer objectId, Integer userId) {
        try(Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, DELETE_SHARED_OBJECT_BY_OBJECT_ID_FOR_USER_ID, "" + objectId, "" + userId);
        }catch (Exception ignore){/*IGNORE*/}
    }

    @Override
    public void deleteSharedObjectsByOwnerIdForUserId(Integer ownerId, Integer userId) {
        try(Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, DELETE_SHARED_OBJECTS_BY_OWNER_ID_FOR_USER_ID, "" + ownerId, "" + userId);
        }catch (Exception ignore){/*IGNORE*/}
    }
}
