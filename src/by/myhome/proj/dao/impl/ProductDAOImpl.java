package by.myhome.proj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.myhome.proj.dao.ProductDAO;
import by.myhome.proj.dao.exception.DAOException;
import by.myhome.proj.dao.impl.pool.ConnectionPool;
import by.myhome.proj.dao.impl.pool.ConnectionPoolException;
import by.myhome.proj.domain.Product;

public class ProductDAOImpl implements ProductDAO {

	private static Connection con;
	private static PreparedStatement prestmt;
	private static Statement stmt;
	private static ResultSet rs;
	private String query;

	@Override
	public List<Product> getProduct(Integer categoryId) throws DAOException {

		List<Product> products = new ArrayList<>();

		query = "select product.id, product.name, product.description, product.price, firm.nameFirm, firm.idfirm, category.nameCategory from product inner join category on category.idCategory=product.categoryId inner join firm on firm.idfirm=product.firmId where product.categoryId=?";
		try {
			con = ConnectionPool.getInstance().takeConnection();
		} catch (ConnectionPoolException e1) {
			throw new DAOException();
		}

		try {

			prestmt = con.prepareStatement(query);
			prestmt.setInt(1, categoryId);
			rs = prestmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();

				int sqlId = rs.getInt(1);
				String sqlName = rs.getString(2);
				String sqlDescription = rs.getString(3);
				String sqlPrice = rs.getString(4);
				String sqlNameFirm = rs.getString(5);
				int sqlFirmId = rs.getInt(6);
				String sqlNameCategory = rs.getString(7);
				//int sqlCategoryName = rs.getInt(8);
				

				product.setId(sqlId);
				product.setProductName(sqlName);
				product.setProductFirm(sqlNameFirm);
				product.setProductCategory(sqlNameCategory);
				product.setProductDescription(sqlDescription);
				product.setProductPrice(sqlPrice);
				product.setCategoryId(categoryId);
				product.setFirmId(sqlFirmId);

				products.add(product);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			ConnectionPool.getInstance().releaseConnection(con);
		} catch (ConnectionPoolException e) {
		}

		return products;
	}

	@Override
	public Product getProductById(Integer productId) throws DAOException {
		Product product = new Product();
		query = "select product.id, product.name, product.description, product.price, firm.nameFirm, firm.idfirm, product.categoryId, category.nameCategory from product "
			+ "inner join firm on firm.idfirm=product.firmId "
			+ "inner join category on category.idcategory=product.categoryId"
			+ " where product.id=?";

		try {
			con = ConnectionPool.getInstance().takeConnection();
		} catch (ConnectionPoolException e1) {
			throw new DAOException();
		}

		try {

			prestmt = con.prepareStatement(query);
			prestmt.setInt(1, productId);
			rs = prestmt.executeQuery();
			while (rs.next()) {

				int sqlId = rs.getInt(1);
				String sqlName = rs.getString(2);
				String sqlDescription = rs.getString(3);
				String sqlPrice = rs.getString(4);
				String sqlNameFirm = rs.getString(5);
				int sqlIdFirm = rs.getInt(6);
				int sqlCategoryId = rs.getInt(7);
				String sqlCategoryName = rs.getString(8);

				product.setId(sqlId);
				product.setProductName(sqlName);
				product.setProductFirm(sqlNameFirm);
				product.setProductDescription(sqlDescription);
				product.setProductPrice(sqlPrice);
				product.setCategoryId(sqlCategoryId);
				product.setProductCategory(sqlCategoryName);
				product.setFirmId(sqlIdFirm);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			ConnectionPool.getInstance().releaseConnection(con);
		} catch (ConnectionPoolException e) {
		}

		return product;

	}

	@Override
	public Product deleteProductById(Integer productId) throws SQLException {
		query = "select product.categoryId from product where product.id=?";
		Product product = new Product();

		try {
			con = ConnectionPool.getInstance().takeConnection();
		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		prestmt = con.prepareStatement(query);
		prestmt.setInt(1, productId);
		rs = prestmt.executeQuery();
		while (rs.next()) {
			int sqlCategoryId = rs.getInt(1);
			product.setCategoryId(sqlCategoryId);
		}

		query = "delete from product where product.id=?";

		try {
			con = ConnectionPool.getInstance().takeConnection();
		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		prestmt = con.prepareStatement(query);
		prestmt.setInt(1, productId);
		prestmt.executeUpdate();

		try {
			ConnectionPool.getInstance().releaseConnection(con);
		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}

	public List<Product> getFirm() throws SQLException{
		List<Product> products = new ArrayList<>();
		
		query ="select firm.idfirm,firm.nameFirm from firm" ;
		try {
			con = ConnectionPool.getInstance().takeConnection();
		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (rs.next()){
			int idFirm = rs.getInt(1);
			String firm = rs.getString(2);
			Product product = new Product();
			product.setFirmId(idFirm);
			product.setProductFirm(firm);
			products.add(product);
		}
		try {
			ConnectionPool.getInstance().releaseConnection(con);
		} catch (ConnectionPoolException e) {
		}
		return products;
		
	}

	@Override
	public void addProductToDataBase(Product product) {
		query = "insert into product (categoryId, firmId, name, description, price)"+"values(?, ?, ?, ?, ?)";
		
		try {
			con = ConnectionPool.getInstance().takeConnection();
		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prestmt = con.prepareStatement(query);
			prestmt.setInt(1, product.getCategoryId());
			prestmt.setInt(2, product.getFirmId());
			prestmt.setString(3, product.getProductName());
			prestmt.setString(4, product.getProductDescription());
			prestmt.setString(5, product.getProductPrice());
			prestmt.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ConnectionPool.getInstance().releaseConnection(con);
		} catch (ConnectionPoolException e) {
		}
		
		
	}

	@Override
	public List<Product> getCategory() throws SQLException {
List<Product> products = new ArrayList<>();
		
		query ="select category.idcategory,category.nameCategory from category" ;
		try {
			con = ConnectionPool.getInstance().takeConnection();
		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (rs.next()){
			int idCategory = rs.getInt(1);
			String category = rs.getString(2);
			Product product = new Product();
			product.setCategoryId(idCategory);
			product.setProductCategory(category);
			products.add(product);
		}
		try {
			ConnectionPool.getInstance().releaseConnection(con);
		} catch (ConnectionPoolException e) {
		}
		return products;
	}

	@Override
	public void editProductInDataBase(Product product) {
		query="update product set categoryId=?, firmId=?, name=?, description=?, price=? where product.id=?";
		try {
			con = ConnectionPool.getInstance().takeConnection();
		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prestmt = con.prepareStatement(query);
			prestmt.setInt(1, product.getCategoryId());
			prestmt.setInt(2, product.getFirmId());
			prestmt.setString(3, product.getProductName());
			prestmt.setString(4, product.getProductDescription());
			prestmt.setString(5, product.getProductPrice());
			prestmt.setInt(6, product.getProductId());
			prestmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ConnectionPool.getInstance().releaseConnection(con);
		} catch (ConnectionPoolException e) {
		}
	}

	@Override
	public List<Product> getAllProductFromDB() throws DAOException {
		List<Product> products = new ArrayList<>();

		query = "select product.id, product.name, product.description, product.price, firm.nameFirm, firm.idfirm, category.nameCategory, category.idcategory from product inner join category on category.idCategory=product.categoryId inner join firm on firm.idfirm=product.firmId ";
		try {
			con = ConnectionPool.getInstance().takeConnection();
		} catch (ConnectionPoolException e1) {
			throw new DAOException();
		}

		try {

			prestmt = con.prepareStatement(query);
			
			rs = prestmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();

				int sqlId = rs.getInt(1);
				String sqlName = rs.getString(2);
				String sqlDescription = rs.getString(3);
				String sqlPrice = rs.getString(4);
				String sqlNameFirm = rs.getString(5);
				int sqlFirmId = rs.getInt(6);
				String sqlNameCategory = rs.getString(7);
				int sqlCategoryId = rs.getInt(8);
				

				product.setId(sqlId);
				product.setProductName(sqlName);
				product.setProductFirm(sqlNameFirm);
				product.setProductCategory(sqlNameCategory);
				product.setProductDescription(sqlDescription);
				product.setProductPrice(sqlPrice);
				product.setCategoryId(sqlCategoryId);
				product.setFirmId(sqlFirmId);

				products.add(product);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			ConnectionPool.getInstance().releaseConnection(con);
		} catch (ConnectionPoolException e) {
		}

		return products;
		
	}

	
	
	
}
