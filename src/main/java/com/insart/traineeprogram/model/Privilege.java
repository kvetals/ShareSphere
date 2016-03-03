package com.insart.traineeprogram.model;

/**
 * Created by Семья on 23.01.2016.
 */
public class Privilege {
    private Integer privilegeId;
    private String privilegeCaption;

    public Integer getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilegeCaption() {
        return privilegeCaption;
    }

    public void setPrivilegeCaption(String privilegeCaption) {
        this.privilegeCaption = privilegeCaption;
    }

    public String toString(){
        return getPrivilegeId() + " " + getPrivilegeCaption();
    }
}
