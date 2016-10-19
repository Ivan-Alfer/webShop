package by.myhome.proj.command.impl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.myhome.proj.command.exception.CommandException;
import by.myhome.proj.domain.User;
import by.myhome.proj.service.ServiceFactory;
import by.myhome.proj.service.UserService;
import by.myhome.proj.service.exception.ServiceException;

public class RegistrationCommand extends BaseProduct {

	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String FIRSTNAME = "firstName";
	private static final String LASTNAME = "lastName";

	private static final String MAIN_PAGE = "WEB-INF/jsp/main.jsp";

	
	public void executeRaw(HttpServletRequest request, HttpServletResponse response)
			throws  CommandException, ServiceException {

		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		String firstName = request.getParameter(FIRSTNAME);
		String lastName = request.getParameter(LASTNAME);

		User user = new User();

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setLogin(login);
		user.setPassword(password);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();

		User currentUser = userService.registerUser(user);

		HttpSession session = request.getSession();
		session.setAttribute("user", currentUser);

		Cookie userIdCookie = new Cookie("userId", currentUser.getId().toString());
		response.addCookie(userIdCookie);

		String goToPage;

		goToPage = MAIN_PAGE;

		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);
		
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				throw new CommandException(e);
			}
		
	}

}
