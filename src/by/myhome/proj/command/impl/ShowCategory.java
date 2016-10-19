package by.myhome.proj.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.myhome.proj.command.exception.CommandException;
import by.myhome.proj.domain.Category;
import by.myhome.proj.service.CategoryService;
import by.myhome.proj.service.ServiceFactory;
import by.myhome.proj.service.exception.ServiceException;
import by.myhome.proj.service.exception.ServiceRegistrationException;

public class ShowCategory extends BaseProduct{

	
	public void executeRaw(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServiceRegistrationException, ServiceException {
		
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		CategoryService categoryService = serviceFactory.getCategoryService();
		List<Category> category = categoryService.getCategory();
		
		request.setAttribute("category", category);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/show_category.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}
	}

}
