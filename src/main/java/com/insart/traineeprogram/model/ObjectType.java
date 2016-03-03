package com.insart.traineeprogram.model;

/**
 * Created by Семья on 23.01.2016.
 */
public class ObjectType {
    private Integer objectTypeId;
    private String objectTypeCaption;

    public Integer getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(Integer objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public String getObjectTypeCaption() {
        return objectTypeCaption;
    }

    public void setObjectTypeCaption(String objectTypeCaption) {
        this.objectTypeCaption = objectTypeCaption;
    }

    public String toString(){
        return getObjectTypeId() + " " + getObjectTypeCaption();
    }
}
