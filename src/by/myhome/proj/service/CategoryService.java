package by.myhome.proj.service;

import java.util.List;

import by.myhome.proj.domain.Category;
import by.myhome.proj.service.exception.ServiceException;

public interface CategoryService {
	
	List<Category> getCategory() throws ServiceException;

}
