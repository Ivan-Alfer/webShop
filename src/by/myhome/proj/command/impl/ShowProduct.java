package by.myhome.proj.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.myhome.proj.command.exception.CommandException;
import by.myhome.proj.domain.Product;
import by.myhome.proj.service.ProductService;
import by.myhome.proj.service.ServiceFactory;
import by.myhome.proj.service.exception.ServiceException;
import by.myhome.proj.service.exception.ServiceRegistrationException;

public class ShowProduct extends BaseProduct{

	private static final String ID = "id";

	
	public void executeRaw(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServiceRegistrationException, ServiceException {

		HttpSession session = request.getSession(false);

		if (session == null) {
			request.setAttribute("errorMessage", "LOGIN PLEASE!");
			try {
				request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return;
		}

		String sId = request.getParameter(ID);

		Integer categoryId = Integer.valueOf(sId);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ProductService productService = serviceFactory.getProductService();

		List<Product> products = productService.getCatalog(categoryId);

		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/show_product.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}
	}

}
