package by.myhome.proj.controller;

import java.util.HashMap;
import java.util.Map;

import by.myhome.proj.command.Command;
import by.myhome.proj.command.admin.impl.AddProduct;
import by.myhome.proj.command.admin.impl.AdminAllProduct;
import by.myhome.proj.command.admin.impl.AdminShowCategories;
import by.myhome.proj.command.admin.impl.AdminShowProduct;
import by.myhome.proj.command.admin.impl.DeleteProduct;
import by.myhome.proj.command.admin.impl.EditProduct;
import by.myhome.proj.command.admin.impl.GoToAddProduct;
import by.myhome.proj.command.admin.impl.GoToEditProduct;
import by.myhome.proj.command.impl.AddToBasket;
import by.myhome.proj.command.impl.DeleteFromBasket;

import by.myhome.proj.command.impl.GoToBasket;
import by.myhome.proj.command.impl.GoToMainPage;
import by.myhome.proj.command.impl.GoToRegistrationCommand;
import by.myhome.proj.command.impl.LogOut;
import by.myhome.proj.command.impl.LoginationCommand;
import by.myhome.proj.command.impl.RegistrationCommand;
import by.myhome.proj.command.impl.ShowCategory;
import by.myhome.proj.command.impl.ShowProduct;

public class CommandHelper {
	
	private Map<CommandName, Command> commands = new HashMap<>();
	
	CommandHelper() {
		commands.put(CommandName.GO_TO_MAIN_PAGE, new GoToMainPage());
		commands.put(CommandName.LOGINATION, new LoginationCommand());
		commands.put(CommandName.REGISTRATION, new RegistrationCommand());
		commands.put(CommandName.GO_TO_REGISTRATION,new GoToRegistrationCommand());
		commands.put(CommandName.SHOW_CATEGORY, new ShowCategory());
		commands.put(CommandName.SHOW_PRODUCT, new ShowProduct());
		commands.put(CommandName.ADD_TO_BASKET, new AddToBasket());
		commands.put(CommandName.GO_TO_BASKET, new GoToBasket());
		commands.put(CommandName.LOGOUT, new LogOut());
		commands.put(CommandName.DELETE_FROM_BASKET, new DeleteFromBasket());
		commands.put(CommandName.ADMIN_SHOW_CATEGORY, new AdminShowCategories());
		commands.put(CommandName.ADMIN_SHOW_PRODUCT, new AdminShowProduct());
		commands.put(CommandName.DELETE_PRODUCT, new DeleteProduct());
		commands.put(CommandName.GO_TO_ADD_PRODUCT, new GoToAddProduct());
		commands.put(CommandName.ADD_PRODUCT, new AddProduct());
		commands.put(CommandName.GO_TO_EDIT_PRODUCT, new GoToEditProduct());
		commands.put(CommandName.EDIT_PRODUCT, new EditProduct());
		commands.put(CommandName.ADMIN_ALL_PRODUCTS, new AdminAllProduct());
	}
	
	Command getCommand(String name){
		CommandName commandName = CommandName.valueOf(name.toUpperCase());
		Command command = commands.get(commandName);
		return command;
	}

}
