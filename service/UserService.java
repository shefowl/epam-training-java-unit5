package by.epam.money.service;

import by.epam.money.bean.User;

public interface UserService {
    User signIn(String login, String password) throws ServiceException;
    void signOut(User user) throws ServiceException;
}
