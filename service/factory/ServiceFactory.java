package by.epam.money.service.factory;

import by.epam.money.service.AccountIdGenerator;
import by.epam.money.service.AccountService;
import by.epam.money.service.UserService;
import by.epam.money.service.impl.AccountServiceImpl;
import by.epam.money.service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final AccountService accountService = new AccountServiceImpl();
    private final AccountIdGenerator idGenerator;

    private ServiceFactory(){
        idGenerator = AccountIdGenerator.getInstance();
    }

    public static ServiceFactory getInstance(){
        return instance;
    }

    public UserService getUserService(){
        return userService;
    }

    public AccountService getAccountService(){
        return accountService;
    }


}
