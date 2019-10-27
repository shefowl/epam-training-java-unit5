package by.epam.money.controller.impl;

import by.epam.money.bean.Account;
import by.epam.money.controller.Command;
import by.epam.money.service.AccountService;
import by.epam.money.service.ServiceException;
import by.epam.money.service.factory.ServiceFactory;

public class UpdateAccount implements Command {
    @Override
    public String execute(String request) {
        int id = Integer.parseInt(request.substring(0, request.indexOf(' ')));
        float balance = Float.parseFloat(request.substring(request.indexOf(' ') + 1));
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AccountService accountService = serviceFactory.getAccountService();

        try {
            accountService.updateAccount(new Account(id, balance));
            response = "Account updated";
        } catch (ServiceException e) {
            response = "Error during updating account";
        }
        return response;
    }
}
