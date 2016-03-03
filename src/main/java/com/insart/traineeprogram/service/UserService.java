package com.insart.traineeprogram.service;

import com.insart.traineeprogram.dao.UsersDAO;
import com.insart.traineeprogram.model.User;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by v.kovtun on 14.02.2016.
 */
public class UserService {
	private UsersDAO usersDAO;

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public boolean registerNewUser(String userLogin, String userPassword, String userEmail, Integer roleId){
        boolean result = false;
        User user = new User(userLogin, userPassword, userEmail, roleId);
        if (!usersDAO.isExist(userLogin)) {
            usersDAO.addUser(user);
            result = true;
        }
        return result;
    }

    public User authenticateUser(String userLogin, String userPassword){
        return usersDAO.getUserByLoginAndPassword(userLogin, userPassword);
    }

    public String resetUserPassword(String eMail){
        User user = usersDAO.getUserByEmail(eMail);
        String newPassword = "";
        if (user != null) {
            newPassword += 100_000_000 + new Random().nextInt(899_999_999);
            usersDAO.changePasswordByUserId(newPassword, user.getUserId());
        }
        return newPassword;
    }

    public void changeUserPassword(Integer userId, String newPassword){
        usersDAO.changePasswordByUserId(newPassword, userId);
    }
    
    public void logout(HttpServletRequest request, HttpServletResponse response){
    	request.getSession().invalidate();
    }
}
