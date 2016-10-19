package by.myhome.proj.command.admin.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.myhome.proj.command.exception.CommandException;
import by.myhome.proj.command.impl.BaseProduct;
import by.myhome.proj.domain.Product;
import by.myhome.proj.service.ProductService;
import by.myhome.proj.service.ServiceFactory;
import by.myhome.proj.service.exception.ServiceException;

public class GoToAddProduct extends BaseProduct{
	public void executeRaw(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServiceException {

		ServiceFactory serviseFactory = ServiceFactory.getInstance();
		ProductService productService = serviseFactory.getProductService();

		List<Product> firms = productService.getFirms();

		request.setAttribute("firms", firms);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add_product.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}

	}
}
