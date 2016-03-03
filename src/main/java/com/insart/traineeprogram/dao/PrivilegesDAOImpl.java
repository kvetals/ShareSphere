package com.insart.traineeprogram.dao;

import com.insart.traineeprogram.model.Privilege;
import com.insart.traineeprogram.utils.MyDbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.insart.traineeprogram.utils.DaoUtils.*;

/**
 * Created by Семья on 24.01.2016.
 */
public class PrivilegesDAOImpl implements PrivilegesDAO {
	
	public boolean isIdExists(int id){
		return getPrivilegeById(id) != null;
	}
    
    public boolean isCaptionExists(String caption){
		return getPrivilegeByCaption(caption) != null;
    }

    public List<Privilege> getPrivileges() {
        List<Privilege> privilegesList = new ArrayList<>();
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_ALL_PRIVILEGES);
            privilegesList = parseResultSet(resultSet, privilegesList, Privilege.class);
        }catch (SQLException e){/*IGNORE*/}
        return privilegesList;
    }

    public void addPrivilege(String caption) {
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, ADD_PRIVILEGE, caption);
        }catch (SQLException e){/*IGNORE*/}
    }

    public void addPrivilegeByIndex(int index, String caption) {
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, ADD_PRIVILEGE_BY_INDEX, "" + index, caption);
        }catch (SQLException e){/*IGNORE*/}
    }

    public Privilege getPrivilegeById(Integer id) {
        Privilege privilege = null;
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_PRIVILEGE_BY_ID, "" + id);
            privilege = parseResultSet(resultSet, Privilege.class);
        }catch (SQLException e){/*IGNORE*/}
        return privilege;
    }

    public Privilege getPrivilegeByCaption(String caption) {
        Privilege privilege = null;
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_PRIVILEGE_BY_CAPTION, caption);
            privilege = parseResultSet(resultSet, Privilege.class);
        }catch (SQLException e){/*IGNORE*/}
        return privilege;
    }

    public void deletePrivilegeById(int id) {
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, DELETE_PRIVILEGE_BY_ID, "" + id);
        }catch (SQLException e){/*IGNORE*/}
    }

    public void deletePrivilegeByCaption(String caption) {
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, DELETE_PRIVILEGE_BY_CAPTION, caption);
        }catch (SQLException e){/*IGNORE*/}
    }

}
