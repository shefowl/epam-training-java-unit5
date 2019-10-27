package by.epam.money.dao;

import by.epam.money.bean.User;

import java.io.FileNotFoundException;

public interface UserDAO {
    User signIn(String login, String password) throws DAOException, FileNotFoundException;
    void signOut(User user) throws DAOException;
}
