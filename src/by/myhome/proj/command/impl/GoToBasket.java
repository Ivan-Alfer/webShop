package by.myhome.proj.command.impl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.myhome.proj.service.exception.ServiceException;

public class GoToBasket extends BaseProduct {

	@Override
	public void executeRaw(HttpServletRequest request, HttpServletResponse response)
			throws ServiceException {
		//List<Product> temp=(List<Product>) request.getSession().getAttribute("products");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/basket");
		
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				throw new ServiceException();
			}
		
		
	}

}
