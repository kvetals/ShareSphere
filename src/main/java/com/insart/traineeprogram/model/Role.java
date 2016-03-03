package com.insart.traineeprogram.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Семья on 23.01.2016.
 */
public class Role {
    private Integer roleId;
    private String roleCaption;
    
    private Set<User> userSet = new HashSet<>();

    public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	
	public Role(){}
	public Role(String roleCaption){
		this.roleCaption = roleCaption;
	}

	public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleCaption() {
        return roleCaption;
    }

    public void setRoleCaption(String roleCaption) {
        this.roleCaption = roleCaption;
    }

    public String toString(){
        return getRoleId() + " " + getRoleCaption();
    }
}
