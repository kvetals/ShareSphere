package com.insart.traineeprogram.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.*;

import com.insart.traineeprogram.model.User;
import com.insart.traineeprogram.service.UserService;
import com.insart.traineeprogram.utils.SpringUtils;


@WebServlet(description = "Login servlet", urlPatterns = { "/login" })
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger("LoginControllerServlet");

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		logger.entry();
		System.out.println("Entered servlet");
		User user = new User();
		if((request.getParameter("login") != null && request.getParameter("password") != null) && !request.getParameter("login").trim().equals("")){
			System.out.println("Entered first IF");
			user.setUserLogin(request.getParameter("login"));
			user.setUserPassword(request.getParameter("password"));
		}else if( request.getSession().getAttribute("user") != null){
			System.out.println("Entered first ELSE");
			user = (User) request.getSession().getAttribute("user");
			response.sendRedirect("html/main-page.html");
//			logger.exit();
			return;
		}
//		
		UserService userService = SpringUtils.getContext().getBean("userService", UserService.class);
		user = userService.authenticateUser(user.getUserLogin(), user.getUserPassword());
		System.out.println("USER IS = " + user);
		if(user != null){
			System.out.println("Entered user != null IF");
			request.getSession().setAttribute("user", user); 
			response.sendRedirect("html/main-page.html");
			System.out.println(request.getContextPath());
			return;
//			logger.exit();
		}else{
			System.out.println("Entered user == null ELSE");
			doGet(request, response);
//			logger.exit();
		}
		response.getWriter().append("Hello world");
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath());
	}

}
