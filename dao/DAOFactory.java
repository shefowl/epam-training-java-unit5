package by.epam.money.dao;

import by.epam.money.dao.impl.FileAccountDAO;
import by.epam.money.dao.impl.FileUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final AccountDAO accountDAO = new FileAccountDAO();
    private final UserDAO userDAO = new FileUserDAO();

    private DAOFactory() {
          //  accountDAO ;
        }

    public static DAOFactory getInstance(){
        return instance;
    }

    public AccountDAO getAccountDAO(){
        return accountDAO;
    }

    public UserDAO getUserDAO(){
        return userDAO;
    }

}
