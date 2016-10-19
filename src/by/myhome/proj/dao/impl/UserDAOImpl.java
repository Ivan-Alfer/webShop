package by.myhome.proj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.myhome.proj.dao.UserDAO;
import by.myhome.proj.dao.exception.DAOException;
import by.myhome.proj.dao.impl.pool.ConnectionPool;
import by.myhome.proj.dao.impl.pool.ConnectionPoolException;
import by.myhome.proj.domain.User;

public class UserDAOImpl implements UserDAO {

	
	private static Connection con;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	private String query;

	@Override
	public User addNewUser(User user) throws DAOException, SQLException {

		query = "INSERT INTO myproject.user (firstname, lastname, login, password)" + " VALUES (?, ?, ?, ?);";

		try {
			con = ConnectionPool.getInstance().takeConnection();
		} catch (ConnectionPoolException e1) {
			throw new DAOException();
		}

		stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, user.getFirstName());
		stmt.setString(2, user.getLastName());
		stmt.setString(3, user.getLogin());
		stmt.setString(4, user.getPassword());

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException();
		}

		rs = stmt.getGeneratedKeys();

		while (rs.next()) {
			int id = rs.getInt(1);
			user.setId(id);
		}

		try {
			ConnectionPool.getInstance().releaseConnection(con);
		} catch (ConnectionPoolException e) {
		}

		return user;
	}

	public User getUserByLogin(String login) throws DAOException {
		query = "select id, firstname, lastname,login,password,userAdmin from user where login=?";

		try {
			con = ConnectionPool.getInstance().takeConnection();
		} catch (ConnectionPoolException e1) {
			throw new DAOException();
		}

		try {
			con = ConnectionPool.getInstance().takeConnection();

			stmt = con.prepareStatement(query);
			stmt.setString(1, login);
			rs = stmt.executeQuery();

			while (rs.next()) {
				String sqlLogin = rs.getString(4);
				String sqlFirstName = rs.getString(2);
				String sqlLastName = rs.getString(3);
				String sqlPassword = rs.getString(5);
				int sqlId = rs.getInt(1);
				int sqlUserAdmin = rs.getInt(6);
				User user = new User();
				user.setFirstName(sqlFirstName);
				user.setLastName(sqlLastName);
				user.setLogin(sqlLogin);
				user.setPassword(sqlPassword);
				user.setId(sqlId);
				user.setUserAdmin(sqlUserAdmin);
				return user;
			}

		} catch (Exception sqlEx) {
			sqlEx.printStackTrace();
		} finally {

			try {
				ConnectionPool.getInstance().releaseConnection(con);
			} catch (ConnectionPoolException e) {
			}
		}
		return null;
	}
}