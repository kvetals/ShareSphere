package com.insart.traineeprogram.dao;

import com.insart.traineeprogram.model.ObjectType;

import java.util.List;

/**
 * Created by Семья on 13.02.2016.
 */
public interface ObjectTypesDAO {

    String ADD_OBJECT_TYPE = "INSERT INTO object_types (object_type_caption) VALUES (?)";
    String DELETE_OBJECT_TYPE_BY_ID = "DELETE FROM object_types WHERE object_type_id = ?";
    String DELETE_OBJECT_TYPE_BY_CAPTION = "DELETE FROM object_types WHERE object_type_caption = ?";
    String GET_ALL_OBJECT_TYPES = "SELECT * FROM object_types";
    String ADD_OBJECT_TYPE_BY_INDEX = "INSERT INTO object_types (object_type_id, object_type_caption) VALUES (?, ?)";
    String GET_OBJECT_TYPE_BY_ID = "SELECT * FROM object_types WHERE object_type_id = ?";
    String GET_OBJECT_TYPE_BY_CAPTION = "SELECT * FROM object_types WHERE object_type_caption = ?";

    public boolean isIdExists(int id);
    
    public boolean isCaptionExists(String caption);

    public List<ObjectType> getObjectTypes();

    public void addObjectType(String caption);

    public void addObjectTypeByIndex(int index, String caption);

    public ObjectType getObjectTypeById(Integer id);

    public ObjectType getObjectTypeByCaption(String caption);

    public void deleteObjectTypeById(int id);

    public void deleteObjectTypeByCaption(String caption);
}
