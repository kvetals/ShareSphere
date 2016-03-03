package com.insart.traineeprogram.utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;

/**
 * Created by Семья on 24.01.2016.
 */
public class DaoUtils {

    public static ResultSet executeQueryPreparedStatement(Connection connection, String query, String... params){
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            for (int i = 1; i <= params.length; i++) {
                ps.setString(i, params[i - 1]);
            }
            rs = ps.executeQuery();
        }catch (SQLException e){
            System.out.println("Exception from method \"executeQueryPreparedStatement\" on query = " + query);
        }
        return rs;
    }

    public static void executePreparedStatement(Connection connection, String query, String... params) {
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            for (int i = 1; i <= params.length; i++) {
                ps.setString(i, params[i - 1]);
            }
            ps.execute();
        }catch (SQLException e){
            System.out.println("Exception from method \"executePreparedStatement\" on query = " + query);
        }
    }

    public static<T> List<T> parseResultSet(ResultSet resultSet, List<T> list, Class<T> className){
//        Class className = javaBean.getClass();
        ResultSetMetaData rsmd = getResultSetMetaData(resultSet);
        String methodNames[] = getMethodsNamesArray(rsmd);
        try {
            while(resultSet.next()){
                T newObject = getNewJavaBeanInstance(className);
//                T newObject = className.newInstance();
                newObject = fillInJavaBean(resultSet, rsmd, methodNames, newObject, className);
                list.add(newObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static<T> T parseResultSet(ResultSet resultSet, Class<T> className) {
//        Class className = javaBean.getClass();
        ResultSetMetaData rsmd = getResultSetMetaData(resultSet);
        String methodNames[] = getMethodsNamesArray(rsmd);
        T javaBean = null;
        try {
            if(resultSet.next()){
                javaBean = getNewJavaBeanInstance(className);
                javaBean = fillInJavaBean(resultSet, rsmd, methodNames, javaBean, className);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return javaBean;
    }
    
    private static<T> T fillInJavaBean(ResultSet resultSet, ResultSetMetaData rsmd, String[] methodNames, T javaBean, Class javaBeanClass){
        try {

                for (int i = 0; i < methodNames.length; i++){
//                    Method method = null;
//                    Class typeClass = null;
                    if (rsmd.getColumnTypeName(i+1).equals("VARCHAR")) {
//                        typeClass = String.class;
                        javaBeanClass.getDeclaredMethod(methodNames[i], String.class).invoke(javaBean, resultSet.getString(i + 1));
                    }if (rsmd.getColumnTypeName(i+1).equals("INT")){
//                        typeClass = Integer.class;
                        javaBeanClass.getDeclaredMethod(methodNames[i], Integer.class).invoke(javaBean, resultSet.getInt(i + 1));
                    }
//                    method = className.getDeclaredMethod(methodNames[i], typeClass);
                    // TO DO
//                    method.invoke(object, (typeClass.getCanonicalName())resultSet.getObject(i+1));
                    // TO DO
                }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return javaBean;
    }
    
    
    private static<T> T getNewJavaBeanInstance(Class<T> className){
        Object newObject = null;
        try {
            newObject = className.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException while creating new instance");
            e.printStackTrace();
        }
        return (T)newObject;
    }

    private static ResultSetMetaData getResultSetMetaData(ResultSet resultSet){
        ResultSetMetaData rsmd = null;
        try {
            rsmd = resultSet.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsmd;
    }

    private static String[] getMethodsNamesArray(ResultSetMetaData resultSetMetaData){
        String fieldNames[] = null;

        try {
            fieldNames = new String[resultSetMetaData.getColumnCount()];
        } catch (SQLException e) {
            System.out.println("Exception from getMethodsNamesArray while getting ColumnCount");
            e.printStackTrace();
        }
        for (int i = 0; i < fieldNames.length; i++){
            try {
                fieldNames[i] = convertColumnNameToSetterName(resultSetMetaData.getColumnName(i + 1));
            } catch (SQLException e) {
                System.out.println("Exception from getMethodsNamesArray while getting ColumnNames");
                e.printStackTrace();
            }
        }
        return fieldNames;
    }


    public static String convertColumnNameToSetterName(String columnName){
        String result = "set";
        result += convertCharToBig(columnName.charAt(0));
        for (int i = 1; i < columnName.length(); i++){
            if(columnName.charAt(i) == '_'){
                result += convertCharToBig(columnName.charAt(++i));
            }else result += columnName.charAt(i);
        }
        return result;
    }
    private static char convertCharToBig(char c){
        return (char)((int)c - 32);
    }

}
