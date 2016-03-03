package com.insart.traineeprogram.model;

/**
 * Created by Семья on 23.01.2016.
 */
public class FileSystemObject {
    private Integer fsObjectId;
    private String fsObjectName;
    private Integer objectTypeId;
    private Integer userId;
    private String fsObjectPath;
    private String fsObjectDlLink;

    public Integer getFsObjectId() {
        return fsObjectId;
    }

    public void setFsObjectId(Integer fsObjectId) {
        this.fsObjectId = fsObjectId;
    }

    public String getFsObjectName() {
        return fsObjectName;
    }

    public void setFsObjectName(String fsObjectName) {
        this.fsObjectName = fsObjectName;
    }

    public Integer getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(Integer objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFsObjectPath() {
        return fsObjectPath;
    }

    public void setFsObjectPath(String fsObjectPath) {
        this.fsObjectPath = fsObjectPath;
    }

    public String getFsObjectDlLink() {
        return fsObjectDlLink;
    }

    public void setFsObjectDlLink(String fsObjectDlLink) {
        this.fsObjectDlLink = fsObjectDlLink;
    }

    @Override
    public String toString() {
        return getFsObjectId()+ " " + getFsObjectName()+ " " + getObjectTypeId() + " " + getUserId() + " " + getFsObjectPath() + " " + getFsObjectDlLink();
    }
}
