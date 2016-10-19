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

public class DeleteProduct extends BaseProduct {
	private static final String ID = "id";

	@Override
	public void executeRaw(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServiceException{

		String sId = request.getParameter(ID);
		Integer productId = Integer.valueOf(sId);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ProductService productService = serviceFactory.getProductService();

		List<Product> products = productService.deleteProduct(productId);

		request.setAttribute("products", products);
		// response.sendRedirect(request.getContextPath() +
		// "/administration/show_product");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin_show_product.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}
	}
}
