package by.myhome.proj.service;

import by.myhome.proj.domain.User;
import by.myhome.proj.service.exception.ServiceException;

public interface UserService {
	User loginUser(String login, String password) throws ServiceException;

	User registerUser(User user) throws ServiceException;
	
	
}
