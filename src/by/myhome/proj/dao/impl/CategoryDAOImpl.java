package by.myhome.proj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.myhome.proj.dao.CategoryDAO;
import by.myhome.proj.dao.exception.DAOException;
import by.myhome.proj.dao.impl.pool.ConnectionPool;
import by.myhome.proj.dao.impl.pool.ConnectionPoolException;
import by.myhome.proj.domain.Category;

public class CategoryDAOImpl implements CategoryDAO{


	private static Connection con;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	private String query;
	
	
	
	@Override
	public List<Category> getCategoryName() throws DAOException {
		
		List<Category> categories = new ArrayList<Category>();
		
		query = "select * from myproject.category";
		try {
			con = ConnectionPool.getInstance().takeConnection();
		} catch (ConnectionPoolException e1) {
			throw new DAOException();
		}
		try {
			
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			 while (rs.next()) 
			 {
				
				Category category = new Category();
				 
	            int idCategory = rs.getInt(1);
	            String nameCategory = rs.getString(2);
	            
	            
	            category.setIdCategory(idCategory);
	            category.setNameCategory(nameCategory);
	            
	            categories.add(category);
       
		        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ConnectionPool.getInstance().releaseConnection(con);
		} catch (ConnectionPoolException e) {
		}
		return categories;
		
	}

}
