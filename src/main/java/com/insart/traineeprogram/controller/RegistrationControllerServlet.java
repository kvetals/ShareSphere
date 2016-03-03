package com.insart.traineeprogram.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.insart.traineeprogram.model.User;
import com.insart.traineeprogram.service.UserService;
import com.insart.traineeprogram.utils.SpringUtils;

@WebServlet("/registration")
public class RegistrationControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger("RegistrationControllerServlet");

       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		logger.entry();
		User user = new User();
		UserService userService = SpringUtils.getContext().getBean("userService", UserService.class);
		if((request.getParameter("login") != null && request.getParameter("password") != null && request.getParameter("e-mail") != null) && !request.getParameter("login").trim().equals("")){
			System.out.println("Entered first IF");
			user.setUserLogin(request.getParameter("login"));
			user.setUserPassword(request.getParameter("password"));
			user.setUserEmail(request.getParameter("e-mail"));
			user.setRoleId(2);
			
		}else {
			System.out.println("Entered ELSE");
			response.sendRedirect(request.getContextPath());
//			logger.exit();
			return;
		}
		
		boolean result = userService.registerNewUser(user.getUserLogin(), user.getUserPassword(), user.getUserEmail(), user.getRoleId());
		if(result){
			request.getSession().setAttribute("user", user); 
			response.sendRedirect("html/main-page.html");
		}
		
//		logger.exit();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath());
	}

}
