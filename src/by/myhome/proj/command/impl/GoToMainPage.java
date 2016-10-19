package by.myhome.proj.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.myhome.proj.command.exception.CommandException;
import by.myhome.proj.service.exception.ServiceException;

public class GoToMainPage extends BaseProduct{

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response)
			throws ServiceException, CommandException {
		
		HttpSession session = request.getSession(false);
		
		if(session==null){
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				throw new CommandException(e);
			}
		}else{
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
