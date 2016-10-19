package by.myhome.proj.service;

import java.util.List;

import by.myhome.proj.domain.Product;
import by.myhome.proj.service.exception.ServiceException;

public interface ProductService {
	
	List<Product> getCatalog(Integer categoryId) throws ServiceException ;
	Product getProduct(Integer productId) throws ServiceException;
	List<Product> deleteProduct(Integer productId) throws ServiceException;
	List<Product> getFirms() throws ServiceException;
	List<Product> addProduct(Product product) throws ServiceException;
	List<Product> getCategories() throws ServiceException;
	List<Product> editProduc(Product product) throws ServiceException;
	List<Product> getAllProducts() throws ServiceException;
}
