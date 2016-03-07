package com.insart.traineeprogram.dao.jdbc;

import com.insart.traineeprogram.dao.RolesDAO;
import com.insart.traineeprogram.model.Role;
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
public class RolesDAOImpl implements RolesDAO {
	
	public boolean isIdExists(int id){
		return getRoleById(id) != null;
	}
    
    public boolean isCaptionExists(String caption){
		return getRoleByCaption(caption) != null;
    }
    

    public List<Role> getRoles() {
        List<Role> rolesList = new ArrayList<>();
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_ALL_ROLES);
            rolesList = parseResultSet(resultSet, rolesList, Role.class);
        }catch (SQLException e){/*IGNORE*/}
        return rolesList;
    }

    public void addRole(String caption) {
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, ADD_ROLE, caption);
        }catch (SQLException e){/*IGNORE*/}
    }

    public void addRoleByIndex(int index, String caption) {
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, ADD_ROLE_BY_INDEX, "" + index, caption);
        }catch (SQLException e){/*IGNORE*/}
    }

    public Role getRoleById(Integer id) {
        Role role = null;
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_ROLE_BY_ID, "" + id);
            role = parseResultSet(resultSet, Role.class);
        }catch (SQLException e){/*IGNORE*/}
        return role;
    }

    public Role getRoleByCaption(String caption) {
        Role role = null;
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_ROLE_BY_CAPTION, caption);
            role = parseResultSet(resultSet, Role.class);
        }catch (SQLException e){/*IGNORE*/}
        return role;
    }

    public void deleteRoleById(int id){
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, DELETE_ROLE_BY_ID, "" + id);
        }catch (SQLException e){/*IGNORE*/}
    }

    public void deleteRoleByCaption(String caption){
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, DELETE_ROLE_BY_CAPTION, caption);
        }catch (SQLException e){/*IGNORE*/}
    }
}
