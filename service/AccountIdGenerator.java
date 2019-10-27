package by.epam.money.service;

import by.epam.money.dao.AccountDAO;
import by.epam.money.dao.DAOException;
import by.epam.money.dao.DAOFactory;

public class AccountIdGenerator {
    private static final AccountIdGenerator instance = new AccountIdGenerator();
    private int id;

    public AccountIdGenerator()  {
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            AccountDAO accountDAO = daoObjectFactory.getAccountDAO();
            id = accountDAO.getLastId();
        }catch (DAOException e){
           // throw new ServiceException(e);
        }
    }

    public static AccountIdGenerator getInstance(){
        return instance;
    }

    public void getLastId() throws ServiceException{
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            AccountDAO accountDAO = daoObjectFactory.getAccountDAO();
            id = accountDAO.getLastId();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
