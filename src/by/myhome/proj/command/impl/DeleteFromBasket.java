package by.myhome.proj.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.myhome.proj.domain.Product;
import by.myhome.proj.service.exception.ServiceException;

public class DeleteFromBasket extends BaseProduct {
	private static final String ID = "id";

	@Override
	public void executeRaw(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

		String sId = request.getParameter(ID);
		Integer productId = Integer.valueOf(sId);
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) request.getSession().getAttribute("products");

		Product deletedProduct = null;

		for (Product product : products) {
			Integer idProduct = product.getProductId();
			if (idProduct.equals(productId)) {
				deletedProduct = product;
				break;
			}
		}

		products.remove(deletedProduct);

		try {
			response.sendRedirect(request.getContextPath() + "/shop/basket");
		} catch (IOException e) {
			throw new ServiceException(e);
		}

	}

}
