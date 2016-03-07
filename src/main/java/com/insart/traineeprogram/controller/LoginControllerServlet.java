package com.insart.traineeprogram.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.insart.traineeprogram.model.User;
import com.insart.traineeprogram.service.UserService;
import com.insart.traineeprogram.utils.UserPath;

@Controller
public class LoginControllerServlet {
	
	@Autowired
	UserService userService;
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger("LoginControllerServlet");
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView startPage(HttpSession session){
		Object login = session.getAttribute("userLogin");
		if (login == null){
			System.out.println(login);
			return new ModelAndView("login-page");
		}
		else{
			return new ModelAndView("main-page");
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, @ModelAttribute("user") User user) {
		System.out.println("Entered servlet");
		if((user.getUserLogin() != null && user.getUserPassword() != null) && !user.getUserLogin().trim().equals("")){
			user = userService.authenticateUser(user.getUserLogin(), user.getUserPassword());
		}else {
			return new ModelAndView("login-page", "message", "You entered wrong data!");
		}
		if(user != null){
			UserPath userPath = new UserPath();
			session.setAttribute("userPath", userPath);
			session.setAttribute("userLogin", user.getUserLogin());
			return new ModelAndView("main-page");
//			logger.exit();
		}else{
			return new ModelAndView("login-page", "message", "Wrong login or password.");
//			logger.exit();
		}
	}
}
