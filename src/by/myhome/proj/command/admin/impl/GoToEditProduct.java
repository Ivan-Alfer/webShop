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

public class GoToEditProduct extends BaseProduct {
	
	private static final String ID = "id";
	
	public void executeRaw(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServiceException{

		String sId = request.getParameter(ID);
		Integer productId = Integer.valueOf(sId);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ProductService productService = serviceFactory.getProductService();
		Product product = productService.getProduct(productId);
		request.setAttribute("product", product);

		ServiceFactory serviceFactoryFirm = ServiceFactory.getInstance();
		ProductService productServiceFirm = serviceFactoryFirm.getProductService();
		List<Product> firms = productServiceFirm.getFirms();
		request.setAttribute("firms", firms);

		ServiceFactory serviceFactoryCateg = ServiceFactory.getInstance();
		ProductService productServiceCategory = serviceFactoryCateg.getProductService();
		List<Product> categories = productServiceCategory.getCategories();
		request.setAttribute("categories", categories);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_product.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}

	}

}
