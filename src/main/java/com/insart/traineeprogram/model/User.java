package com.insart.traineeprogram.model;

/**
 * Created by Семья on 05.02.2016.
 */
public class User {
    private Integer userId;
    private Integer roleId;
    private String userLogin;
    private String userPassword;
    private String userEmail;
    
    Role role;

    public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public User(){}
	public User(String userLogin, String userPassword, String userEmail){
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }
    public User(String userLogin, String userPassword, String userEmail, Integer roleId){
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String toString(){
        return getUserId() + " " + getUserLogin() + " " + getUserPassword() + " " + getUserEmail() + " " + getRoleId();
    }
}
