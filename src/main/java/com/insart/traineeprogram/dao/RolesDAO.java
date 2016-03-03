package com.insart.traineeprogram.dao;

import com.insart.traineeprogram.model.Role;

import java.util.List;

/**
 * Created by Семья on 13.02.2016.
 */
public interface RolesDAO {
    
    public static final String ADD_ROLE = "INSERT INTO roles (role_caption) VALUES (?)";
    public static final String ADD_ROLE_BY_INDEX = "INSERT INTO roles (role_id, role_caption) VALUES (?, ?)";

    public static final String GET_ALL_ROLES = "SELECT * FROM roles";
    public static final String GET_ROLE_BY_ID = "SELECT * FROM roles WHERE role_id = ?";
    public static final String GET_ROLE_BY_CAPTION = "SELECT * FROM roles WHERE role_caption = ?";

    public static final String DELETE_ROLE_BY_ID = "DELETE FROM roles WHERE role_id = ?";
    public static final String DELETE_ROLE_BY_CAPTION = "DELETE FROM roles WHERE role_caption = ?";
    
    public boolean isIdExists(int id);
    
    public boolean isCaptionExists(String caption);
    
    public List<Role> getRoles();

    public void addRole(String caption);

    public void addRoleByIndex(int index, String caption);

    public Role getRoleById(Integer id);

    public Role getRoleByCaption(String caption);

    public void deleteRoleById(int id);

    public void deleteRoleByCaption(String caption);
}
