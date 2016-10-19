package by.myhome.proj.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.myhome.proj.service.exception.ServiceException;

public class LogOut extends BaseProduct {

	
	public void executeRaw(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		
		//User user = request.getSession().invalidate();
		HttpSession session = request.getSession(false);
		
		if(session != null)
		{
			session.invalidate();
		}
		
		try {
			response.sendRedirect(request.getContextPath());
		} catch (IOException e) {
			throw new ServiceException(e);
		}
	}

}
