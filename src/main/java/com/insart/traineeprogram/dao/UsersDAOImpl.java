package com.insart.traineeprogram.dao;

import com.insart.traineeprogram.model.User;
import com.insart.traineeprogram.utils.MyDbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.insart.traineeprogram.utils.DaoUtils.*;

/**
 * Created by Семья on 05.02.2016.
 */
public class UsersDAOImpl implements UsersDAO {

    public boolean isExist(String userLogin) {
        User user = null;
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_USER_BY_LOGIN, userLogin);
            user = parseResultSet(resultSet, User.class);
        }catch (SQLException e){/*IGNORE*/}
//        return user.getUserLogin() != null;
        return user != null;
    }

    public  void addUser(User user) {
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, CREATE_NEW_USER, user.getUserLogin(), user.getUserPassword(), user.getUserEmail(), ""+user.getRoleId());
        }catch (SQLException e){/*IGNORE*/}
    }


    public void deleteUserById(Integer id) {
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, DELETE_USER_BY_ID, ""+id);
        }catch (SQLException e){/*IGNORE*/}
    }

    public void deleteUserByLogin(String login) {
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, DELETE_USER_BY_LOGIN, login);
        }catch (SQLException e){/*IGNORE*/}
    }

    public  List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_ALL_USERS);
            userList = parseResultSet(resultSet, userList, User.class);
        }catch (SQLException e){/*IGNORE*/}
        return userList;
    }

    public User getUserById(int index) {
        User user = null;
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_USER_BY_ID, ""+index);
            user = parseResultSet(resultSet, User.class);
        }catch (SQLException e){/*IGNORE*/}
        return user;
    }

    public User getUserByEmail(String email) {
        User user = null;
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_USER_BY_EMAIL, email);
            user = parseResultSet(resultSet, User.class);
        }catch (SQLException e){/*IGNORE*/}
        return user;
    }

    public User getUserByLoginAndPassword(String login, String password) {
        User user = null;
        try (Connection connection = MyDbConnection.getConnection()) {
        	System.out.println("UsualJDBCImplementation is working now");
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_USER_BY_LOGIN_AND_PASSWORD, login, password);
            user = parseResultSet(resultSet, User.class);
        }catch (SQLException e){/*IGNORE*/}
        return user;
    }

    public List<User> getUsersByRoleCaption(String caption) {
        List<User> userList = new ArrayList<>();
        try (Connection connection = MyDbConnection.getConnection()) {
            ResultSet resultSet = executeQueryPreparedStatement(connection, GET_USERS_BY_ROLE_CAPTION, caption);
            userList = parseResultSet(resultSet, userList, User.class);
        }catch (SQLException e){/*IGNORE*/}
        return userList;
    }

    public void changePasswordByUserId(String password, Integer userId){
        try (Connection connection = MyDbConnection.getConnection()) {
            executePreparedStatement(connection, UPDATE_USER_PASSWORD_BY_ID, password, "" + userId);
        }catch (SQLException e){/*IGNORE*/}
    }
}
