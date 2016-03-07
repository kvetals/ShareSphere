package com.insart.traineeprogram.dao.jdbc;

import com.insart.traineeprogram.dao.InitDestroyDAO;
import com.insart.traineeprogram.utils.MyDbConnection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Семья on 14.02.2016.
 */
public class InitDestroyDAOImpl implements InitDestroyDAO {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("dataBaseInitDestroy");
    public void initDb(){
        try(Connection connection = MyDbConnection.getConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate(resourceBundle.getString("CREATE_ROLES_TABLE"));
            statement.executeUpdate(resourceBundle.getString("CREATE_PRIVILEGES_TABLE"));
            statement.executeUpdate(resourceBundle.getString("CREATE_OBJECT_TYPES_TABLE"));
            statement.executeUpdate(resourceBundle.getString("CREATE_USERS_TABLE"));
            statement.executeUpdate(resourceBundle.getString("CREATE_FILE_SYSTEM_OBJECTS_TABLE"));
            statement.executeUpdate(resourceBundle.getString("CREATE_SHARED_OBJECTS_TABLE"));
        }catch (SQLException ignore){System.out.println("error while creating");/*IGNORE*/}

    }
    public void destroyDb(){
        try(Connection connection = MyDbConnection.getConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate(resourceBundle.getString("DROP_SHARED_OBJECTS_TABLE"));
            System.out.println("1-st table deleted");
            statement.executeUpdate(resourceBundle.getString("DROP_FILE_SYSTEM_OBJECTS_TABLE"));
            System.out.println("2-st table deleted");
            statement.executeUpdate(resourceBundle.getString("DROP_USERS_TABLE"));
            System.out.println("3-st table deleted");
            statement.executeUpdate(resourceBundle.getString("DROP_OBJECT_TYPES_TABLE"));
            System.out.println("4-st table deleted");
            statement.executeUpdate(resourceBundle.getString("DROP_PRIVILEGES_TABLE"));
            System.out.println("5-st table deleted");
            statement.executeUpdate(resourceBundle.getString("DROP_ROLES_TABLE"));
            System.out.println("6-st table deleted");

        }catch (SQLException ignore){System.out.println("error while deleting");/*IGNORE*/}
    }
}
