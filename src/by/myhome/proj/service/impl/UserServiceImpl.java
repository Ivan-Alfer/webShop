package by.myhome.proj.service.impl;

import java.sql.SQLException;

import by.myhome.proj.dao.DAOFactory;
import by.myhome.proj.dao.UserDAO;
import by.myhome.proj.dao.exception.DAOException;
import by.myhome.proj.domain.User;
import by.myhome.proj.service.UserService;
import by.myhome.proj.service.exception.ServiceAuthrizationException;
import by.myhome.proj.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	DAOFactory daoFactory = DAOFactory.getInstance();
	UserDAO userDAO = daoFactory.getUserDAO();

	private boolean isUserExists(User user) throws ServiceException  {
		User currentUser = null;
		String login=user.getLogin();
		try {
			currentUser = userDAO.getUserByLogin(login);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		if (currentUser == null) {
			return false;
		}
		return true;
	}

	private boolean validation(String login, String password) {
		if (login == null || login.isEmpty()) {
			return false;
		}
		if (password == null || password.isEmpty()) {
			return false;
		}
		
		return true;
	}

	@Override
	public User loginUser(String login, String password)throws ServiceException{
		User currentLogUser = null;
			if(!validation(login,password)){
				throw new ServiceAuthrizationException();
			}
			try {
				currentLogUser = userDAO.getUserByLogin(login);
			} catch (DAOException e) {
				throw new ServiceAuthrizationException();
			}
			
			if (password.equals(currentLogUser.getPassword())){
				return currentLogUser;
			}else{
				throw new ServiceAuthrizationException();
			}
			
		
	}

	@Override
	public User registerUser(User user) throws ServiceException {
		User currentRegUser = null;
		if (!isUserExists(user)){
			try {
				currentRegUser = userDAO.addNewUser(user);
			} catch (DAOException | SQLException e) {
				throw new ServiceException();
			}
		}else{throw new ServiceAuthrizationException();
		}
		return currentRegUser;
	}
}
