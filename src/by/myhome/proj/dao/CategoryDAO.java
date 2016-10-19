package by.myhome.proj.dao;

import java.util.List;

import by.myhome.proj.dao.exception.DAOException;
import by.myhome.proj.domain.Category;

public interface CategoryDAO {

	List<Category> getCategoryName() throws DAOException;
	
}
