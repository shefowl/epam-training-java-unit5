package by.epam.money.controller.impl;

import by.epam.money.bean.Account;
import by.epam.money.controller.Command;
import by.epam.money.service.AccountService;
import by.epam.money.service.ServiceException;
import by.epam.money.service.factory.ServiceFactory;

public class CreateAccount implements Command {
    @Override
    public String execute(String request) {
        float balance = Float.parseFloat(request);
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AccountService accountService = serviceFactory.getAccountService();

        try {
            accountService.createAccount(new Account(balance));
            response = "Account created";
        } catch (ServiceException e) {
            response = "Error during creating account";
        }
        return response;
    }
}

