package by.myhome.proj.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.myhome.proj.domain.User;
import by.myhome.proj.service.ServiceFactory;
import by.myhome.proj.service.UserService;
import by.myhome.proj.service.exception.ServiceAuthrizationException;
import by.myhome.proj.service.exception.ServiceException;

public class LoginationCommand extends BaseProduct {

	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";

	private static final String MAIN_PAGE = "WEB-INF/jsp/main.jsp";
	private static final String ADMIN_PAGE = "WEB-INF/jsp/main_admin_page.jsp";

	@Override
	public void executeRaw(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

		
		
		String login;
		String password;

		login = request.getParameter(LOGIN);
		password = request.getParameter(PASSWORD);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();

		User currentUser;
		String goToPage;

		try {
			currentUser = userService.loginUser(login, password);

			HttpSession session = request.getSession();
			session.setAttribute("user", currentUser);

			Cookie userIdCookie = new Cookie("userId", currentUser.getId().toString());
			response.addCookie(userIdCookie);

			Integer userAdmin = currentUser.getUserAdmin();
			if (userAdmin != 0) {
				goToPage = ADMIN_PAGE;
			} else {
				goToPage = MAIN_PAGE;
			}

		} catch (ServiceAuthrizationException e1) {
			request.setAttribute("errorMessage", "Wrong login or password.");
			e1.printStackTrace();

			goToPage = "index.jsp";

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(goToPage);

		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
