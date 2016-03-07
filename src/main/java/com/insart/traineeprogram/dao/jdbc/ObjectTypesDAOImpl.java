package com.insart.traineeprogram.dao.jdbc;

import com.insart.traineeprogram.dao.ObjectTypesDAO;
import com.insart.traineeprogram.model.ObjectType;
import com.insart.traineeprogram.utils.MyDbConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.insart.traineeprogram.utils.DaoUtils.*;

/**
 * Created by Семья on 07.02.2016.
 */
public class ObjectTypesDAOImpl implements ObjectTypesDAO {
    Logger logger = LogManager.getLogger(this.getClass());
    
	public boolean isIdExists(int id){
		return getObjectTypeById(id) != null;
	}
    
    public boolean isCaptionExists(String caption){
		return getObjectTypeByCaption(caption) != null;
    }

    public void addObjectType(String caption) {
        logger.entry();
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, ADD_OBJECT_TYPE, caption);
        }catch (SQLException e){/*IGNORE*/}
    }

    public void addObjectTypeByIndex(int index, String caption) {
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, ADD_OBJECT_TYPE_BY_INDEX, "" + index, caption);
        }catch (SQLException e){/*IGNORE*/}
    }

    public List<ObjectType> getObjectTypes() {
        List<ObjectType> objectTypesList = new ArrayList<>();
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_ALL_OBJECT_TYPES);
            objectTypesList = parseResultSet(resultSet, objectTypesList, ObjectType.class);
        }catch (SQLException e){/*IGNORE*/}
        return objectTypesList;
    }

    public ObjectType getObjectTypeById(Integer id) {
        ObjectType objectType = null;
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_OBJECT_TYPE_BY_ID, "" + id);
            objectType = parseResultSet(resultSet, ObjectType.class);
        }catch (SQLException e){/*IGNORE*/}
        return objectType;
    }

    public ObjectType getObjectTypeByCaption(String caption) {
        ObjectType objectType = null;
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_OBJECT_TYPE_BY_CAPTION, caption);
            objectType = parseResultSet(resultSet, ObjectType.class);
        }catch (SQLException e){/*IGNORE*/}
        return  objectType;
    }

    public void deleteObjectTypeById(int id){
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, DELETE_OBJECT_TYPE_BY_ID, "" + id);
        }catch (SQLException e){/*IGNORE*/}
    }

    public void deleteObjectTypeByCaption(String caption) {
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, DELETE_OBJECT_TYPE_BY_CAPTION, caption);
        }catch (SQLException e){/*IGNORE*/}
    }
}
