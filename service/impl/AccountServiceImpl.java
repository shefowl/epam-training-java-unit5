package by.epam.money.service.impl;

import by.epam.money.bean.Account;
import by.epam.money.dao.AccountDAO;
import by.epam.money.dao.DAOException;
import by.epam.money.dao.DAOFactory;
import by.epam.money.service.AccountIdGenerator;
import by.epam.money.service.AccountService;
import by.epam.money.service.ServiceException;

public class AccountServiceImpl implements AccountService {
    @Override
    public void createAccount(Account account) throws ServiceException {
        if(account == null) {
            throw new ServiceException("Incorrect account");
        }
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            AccountDAO accountDAO = daoObjectFactory.getAccountDAO();
            AccountIdGenerator idGenerator = AccountIdGenerator.getInstance();
            account.setId(idGenerator.getId() + 1);
            accountDAO.createAccount(account);
        }
        catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public Account readAccount(int id) throws ServiceException {
        if(id <= 0) {
            throw new ServiceException("Incorrect id");
        }
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            AccountDAO accountDAO = daoObjectFactory.getAccountDAO();
            return accountDAO.readAccount(id);
        }
        catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateAccount(Account account) throws ServiceException {
        if(account == null) {
            throw new ServiceException("Incorrect account");
        }
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            AccountDAO accountDAO = daoObjectFactory.getAccountDAO();
            accountDAO.updateAccount(account);
        }
        catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteAccount(int id) throws ServiceException {
        if(id <= 0) {
            throw new ServiceException("Incorrect id");
        }
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            AccountDAO accountDAO = daoObjectFactory.getAccountDAO();
            accountDAO.deleteAccount(id);
        }
        catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
