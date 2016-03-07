package com.insart.traineeprogram.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.insart.traineeprogram.model.User;
import com.insart.traineeprogram.service.UserService;
import com.insart.traineeprogram.utils.SpringUtils;

@Controller
public class LogoutControllerServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger("LogoutControllerServlet");
    
	@Autowired
	UserService userService;
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		userService.logout(request);
		return new ModelAndView("login-page").addObject("message", "Logout successful.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
