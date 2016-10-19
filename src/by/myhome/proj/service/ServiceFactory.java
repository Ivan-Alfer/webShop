package by.myhome.proj.service;

import by.myhome.proj.service.impl.CategoryServiceImpl;
import by.myhome.proj.service.impl.ProductServiceImpl;
import by.myhome.proj.service.impl.UserServiceImpl;

public class ServiceFactory {

	private static final ServiceFactory instanse = new ServiceFactory();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instanse;
	}

	private static UserService userService = new UserServiceImpl();

	public UserService getUserService() {
		return userService;
	}

	private static ProductService productService = new ProductServiceImpl();

	public ProductService getProductService() {
		return productService;
	}

	private static CategoryService categoryService = new CategoryServiceImpl();

	public CategoryService getCategoryService() {
		return categoryService;
	}
}
