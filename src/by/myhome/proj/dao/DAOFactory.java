package by.myhome.proj.dao;

import by.myhome.proj.dao.impl.CategoryDAOImpl;
import by.myhome.proj.dao.impl.ProductDAOImpl;
import by.myhome.proj.dao.impl.UserDAOImpl;

public class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();
	private UserDAO userDAO = new UserDAOImpl();
	private ProductDAO productDAO = new ProductDAOImpl();
	private CategoryDAO categoryDAO = new CategoryDAOImpl();

	private DAOFactory() {
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public ProductDAO getProductDAO(){
		return productDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}
	
	public CategoryDAO getCategoryDAO(){
		return categoryDAO;
	}

}
