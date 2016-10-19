package by.myhome.proj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.myhome.proj.command.Command;

public class Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private final CommandHelper commandHelper = new CommandHelper();
	private static final String COMMAND = "command";
	
	public Controller(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter(COMMAND);
		
		if(name == null || name.length() == 0){
			name = getInitParameter(COMMAND);
		}
		
		Command command = commandHelper.getCommand(name);
		
			try {
				command.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
}
