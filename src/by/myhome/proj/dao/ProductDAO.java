package by.myhome.proj.dao;

import java.sql.SQLException;
import java.util.List;

import by.myhome.proj.dao.exception.DAOException;
import by.myhome.proj.domain.Product;

public interface ProductDAO {

	List<Product> getProduct(Integer categoryId) throws DAOException;

	Product getProductById(Integer productId) throws DAOException;

	Product deleteProductById(Integer productId) throws SQLException;

	List<Product> getFirm() throws SQLException;
	
	void addProductToDataBase(Product product);

	List<Product> getCategory() throws SQLException;

	void editProductInDataBase(Product product);

	List<Product> getAllProductFromDB() throws DAOException;

	
}
