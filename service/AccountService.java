package by.epam.money.service;

import by.epam.money.bean.Account;

public interface AccountService {
    void createAccount(Account account) throws ServiceException;
    Account readAccount(int id) throws ServiceException;
    void updateAccount(Account account) throws ServiceException;
    void deleteAccount(int id) throws ServiceException;
}
