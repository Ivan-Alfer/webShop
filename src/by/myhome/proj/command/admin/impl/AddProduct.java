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

public class AddProduct extends BaseProduct {
	
	//private static final String FIRM = "firm";
	private static final String DESCRIPTION = "description";
	private static final String NAME = "name";
	private static final String PRICE = "price";
	private static final String CATEGORY_ID = "categoryId";
	private static final String FIRM_ID = "firmId";
	

	public void executeRaw(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServiceException {
		
		Product product = new Product();
		
		product.setProductDescription(request.getParameter(DESCRIPTION));
		product.setProductName(request.getParameter(NAME));
		product.setProductPrice(request.getParameter(PRICE));
		//product.setProductFirm(request.getParameter(FIRM));
		
		String catId = request.getParameter(CATEGORY_ID);
		Integer categoryId = Integer.valueOf(catId);
		product.setCategoryId(categoryId);
		
		String idFirm = request.getParameter(FIRM_ID);
		Integer firmId = Integer.valueOf(idFirm);
		product.setFirmId(firmId);
		
		
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ProductService productService = serviceFactory.getProductService();
		List<Product> products = productService.addProduct(product);
		
		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin_show_product.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}
	}

}
