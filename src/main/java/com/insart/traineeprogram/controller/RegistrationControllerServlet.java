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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.insart.traineeprogram.model.User;
import com.insart.traineeprogram.service.UserService;
import com.insart.traineeprogram.utils.SpringUtils;
import com.insart.traineeprogram.utils.UserPath;

@Controller
public class RegistrationControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger("RegistrationControllerServlet");
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST )
	protected ModelAndView register(HttpSession session, @ModelAttribute("user") User user) {
		ModelAndView modelAndView;
//		logger.entry();
		if (userService.registerNewUser(user.getUserLogin(), user.getUserPassword(), user.getUserEmail(), 2)){
			user = userService.authenticateUser(user.getUserLogin(), user.getUserPassword());
			UserPath userPath = new UserPath();
			session.setAttribute("userPath", userPath);
			session.setAttribute("userLogin", user.getUserLogin());
			modelAndView = new ModelAndView("main-page", "user", user);
		}else{
			modelAndView = new ModelAndView("login-page", "message", "Something went wrong, maybe such user already exists!");
		}
		return modelAndView;
	}
}
