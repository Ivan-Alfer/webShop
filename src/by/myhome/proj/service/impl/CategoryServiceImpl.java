package by.myhome.proj.service.impl;

import java.util.List;

import by.myhome.proj.dao.CategoryDAO;
import by.myhome.proj.dao.DAOFactory;
import by.myhome.proj.dao.exception.DAOException;
import by.myhome.proj.domain.Category;
import by.myhome.proj.service.CategoryService;
import by.myhome.proj.service.exception.ServiceException;

public class CategoryServiceImpl implements CategoryService{

	DAOFactory daoFactory = DAOFactory.getInstance();
	CategoryDAO categoryDAO = daoFactory.getCategoryDAO();
	
	@Override
	public List<Category> getCategory() throws ServiceException {
		List<Category> category;
		try {
			category = categoryDAO.getCategoryName();
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return category;
	}

}
