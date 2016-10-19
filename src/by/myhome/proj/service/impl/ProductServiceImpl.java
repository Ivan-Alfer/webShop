package by.myhome.proj.service.impl;

import java.sql.SQLException;
import java.util.List;

import by.myhome.proj.dao.DAOFactory;
import by.myhome.proj.dao.ProductDAO;
import by.myhome.proj.dao.exception.DAOException;
import by.myhome.proj.domain.Product;
import by.myhome.proj.service.ProductService;
import by.myhome.proj.service.exception.ServiceException;

public class ProductServiceImpl implements ProductService {

	DAOFactory daoFactory = DAOFactory.getInstance();
	ProductDAO productDAO = daoFactory.getProductDAO();

	@Override
	public List<Product> getCatalog(Integer categoryId) throws ServiceException {
		List<Product> products;
		try {
			products = productDAO.getProduct(categoryId);
		} catch (DAOException e) {
			throw new ServiceException(e);

		}
		return products;
	}

	@Override
	public Product getProduct(Integer productId) throws ServiceException {
		Product product;
		try {
			product = productDAO.getProductById(productId);
		} catch (DAOException e) {
			throw new ServiceException(e);

		}
		return product;
	}

	@Override
	public List<Product> deleteProduct(Integer productId) throws ServiceException{
		List<Product> products;
		Product product;
		try {
			product = productDAO.deleteProductById(productId);
		} catch (SQLException e) {
			throw new ServiceException();
		}
		try {
			products = productDAO.getProduct(product.getCategoryId());
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return products;
	}

	@Override
	public List<Product> getFirms() throws ServiceException {
		List<Product> productFirms;
		try {
			productFirms = productDAO.getFirm();
		} catch (SQLException e) {
			throw new ServiceException();
		}
		return productFirms;
	}

	@Override
	public List<Product> addProduct(Product product) throws ServiceException {
		productDAO.addProductToDataBase(product);
		List<Product> products;
		try {
			products = productDAO.getProduct(product.getCategoryId());
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return products;
	}

	@Override
	public List<Product> getCategories() throws ServiceException{
		List<Product> productCategories;
		try {
			productCategories = productDAO.getCategory();
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
		return productCategories;
	}

	@Override
	public List<Product> editProduc(Product product) throws ServiceException {
		productDAO.editProductInDataBase(product);
		
			List<Product> products;
			try {
				products = productDAO.getAllProductFromDB();
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
		
		return products;
	}

	@Override
	public List<Product> getAllProducts() throws ServiceException {
		List<Product> products;
		try {
			products = productDAO.getAllProductFromDB();
		} catch (DAOException e) {
			throw new ServiceException(e);
			
		}
		return products;
	}

}
