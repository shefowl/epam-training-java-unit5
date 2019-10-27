package by.epam.money.service.impl;

import by.epam.money.bean.User;
import by.epam.money.dao.DAOException;
import by.epam.money.dao.DAOFactory;
import by.epam.money.dao.UserDAO;
import by.epam.money.service.ServiceException;
import by.epam.money.service.UserService;

import java.io.FileNotFoundException;

public class UserServiceImpl implements UserService {
    @Override
    public User signIn(String login, String password) throws ServiceException {
        if(login == null || login.isEmpty()) {
            throw new ServiceException("Incorrect login");
        }
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoObjectFactory.getUserDAO();
            return userDAO.signIn(login, password);
        }
        catch(DAOException | FileNotFoundException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public void signOut(User user) throws ServiceException {
        if(user == null) {
            throw new ServiceException("Incorrect login");
        }
    }
}
