package by.myhome.proj.service.exception;

import by.myhome.proj.dao.exception.DAOException;

public class ServiceRegistrationException extends ServiceException{

	public ServiceRegistrationException(DAOException e) {
		super(e);
	}
	
	

	public ServiceRegistrationException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ServiceRegistrationException(String message, DAOException cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}



	public ServiceRegistrationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
