package by.myhome.proj.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.myhome.proj.command.Command;
import by.myhome.proj.command.exception.CommandException;
import by.myhome.proj.service.exception.ServiceException;

public abstract class BaseProduct implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		try {
			executeRaw(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// redirect to the error page
		}
	}
	
	protected abstract void executeRaw(HttpServletRequest request, HttpServletResponse response) throws ServiceException, CommandException;
}
