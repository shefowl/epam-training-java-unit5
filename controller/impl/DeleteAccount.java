package by.epam.money.controller.impl;

import by.epam.money.bean.Account;
import by.epam.money.controller.Command;
import by.epam.money.service.AccountService;
import by.epam.money.service.ServiceException;
import by.epam.money.service.factory.ServiceFactory;

public class DeleteAccount implements Command {
    @Override
    public String execute(String request) {
        int id = Integer.parseInt(request);
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AccountService accountService = serviceFactory.getAccountService();

        try {
            accountService.deleteAccount(id);
            response = "Account deleted";
        } catch (ServiceException e) {
            response = "Error during deleting account";
        }
        return response;
    }
}
