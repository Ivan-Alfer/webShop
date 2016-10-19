package by.myhome.proj.dao;

import java.sql.SQLException;

import by.myhome.proj.dao.exception.DAOException;
import by.myhome.proj.domain.User;

public interface UserDAO {

	

	User addNewUser(User user) throws DAOException, SQLException;
	
	User getUserByLogin(String login) throws DAOException;

}
