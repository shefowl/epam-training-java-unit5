package by.epam.money.controller.impl;

import by.epam.money.bean.Account;
import by.epam.money.controller.Command;
import by.epam.money.service.AccountService;
import by.epam.money.service.ServiceException;
import by.epam.money.service.factory.ServiceFactory;

public class ReadAccount implements Command {
    @Override
    public String execute(String request) {
        int id = Integer.parseInt(request);
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AccountService accountService = serviceFactory.getAccountService();

        try {
            Account account;
            if((account = accountService.readAccount(id)) != null){
                response = account.toString();
            }
            else {
                response = "No such account";
            }
            //response = "Account created";
        } catch (ServiceException e) {
            response = "Error during reading account";
        }
        return response;
    }
}
