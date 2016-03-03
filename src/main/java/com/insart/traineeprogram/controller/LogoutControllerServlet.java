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

@WebServlet(description = "Logout servlet", urlPatterns = { "/logout", "/html/logout" } )
public class LogoutControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger("LogoutControllerServlet");
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		logger.entry();
		SpringUtils.getContext().getBean("userService", UserService.class).logout(request, response);
		response.sendRedirect(request.getContextPath());
//		logger.exit();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
