package by.epam.money.controller.impl;

import by.epam.money.controller.Command;
import by.epam.money.service.ServiceException;
import by.epam.money.service.UserService;
import by.epam.money.service.factory.ServiceFactory;

public class SignIn implements Command {
    @Override
    public String execute(String request) {
        String login = request.substring(0, request.indexOf(space));
        String password = request.substring(request.indexOf(space));
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        try {
            userService.signIn(login, password);
            response = "Welcome";
        } catch (ServiceException e) {
            response = "Error during login procedure";
        }
        return response;
    }
}
