package com.insart.traineeprogram.model;

/**
 * Created by Семья on 23.01.2016.
 */
public class SharedObject {
    private Integer sharedObjectId;
    private Integer objectId;
    private Integer userId;
    private Integer privilegeId;


    public Integer getSharedObjectId() {
        return sharedObjectId;
    }

    public void setSharedObjectId(Integer sharedObjectId) {
        this.sharedObjectId = sharedObjectId;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String toString(){
        return getSharedObjectId() + " " + getObjectId() + " " + getUserId() + " " + getPrivilegeId();
    }
}
