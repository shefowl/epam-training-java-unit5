package by.epam.money.dao;

import by.epam.money.bean.Account;

public interface AccountDAO {
    void createAccount(Account account) throws DAOException;
    Account readAccount(int id) throws DAOException;
    void updateAccount(Account account) throws DAOException;
    void deleteAccount(int id) throws DAOException;
    int getLastId() throws  DAOException;
}
