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

public class EditProduct extends BaseProduct{
	private static final String ID = "productId";
	private static final String IDCATEGORY = "categoryId";
	private static final String IDFIRM = "firmId";
	private static final String NAME = "productName";
	private static final String DESCRIPTION = "productDescription";
	private static final String PRICE = "productPrice";

	@Override
	public void executeRaw(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServiceException {

		Product product = new Product();

		String id = request.getParameter(ID);
		product.setId(Integer.valueOf(id));

		String categId = request.getParameter(IDCATEGORY);
		product.setCategoryId(Integer.valueOf(categId));

		String firmId = request.getParameter(IDFIRM);
		product.setFirmId(Integer.valueOf(firmId));

		product.setProductName(request.getParameter(NAME));

		product.setProductDescription(request.getParameter(DESCRIPTION));

		product.setProductPrice(request.getParameter(PRICE));

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ProductService productService = serviceFactory.getProductService();

		List<Product> products = productService.editProduc(product);

		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin_all_products.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException(e);
		}
	}

}
