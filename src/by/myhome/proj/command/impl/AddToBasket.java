package by.myhome.proj.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.myhome.proj.domain.Product;
import by.myhome.proj.service.ProductService;
import by.myhome.proj.service.ServiceFactory;
import by.myhome.proj.service.exception.ServiceException;

public class AddToBasket extends BaseProduct {
	
	private static final String ID = "id";
	List<Product> products=new ArrayList<Product>();
	
	public void executeRaw(HttpServletRequest request, HttpServletResponse response) throws ServiceException{
		
		String sId= request.getParameter(ID);
		Integer productId = Integer.valueOf(sId);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ProductService productService = serviceFactory.getProductService();
		
		Product product = productService.getProduct(productId);
		
		
		products.add(product);
		
		HttpSession session = request.getSession();
		session.setAttribute("products", products);
		
		

		try {
			response.sendRedirect(request.getContextPath() + "/show_product?id="+product.getCategoryId());
		} catch (IOException e) {
			throw new ServiceException(e);
		}
	}		
}
