package by.epam.money.dao.impl;

import by.epam.money.bean.User;
import by.epam.money.dao.DAOException;
import by.epam.money.dao.UserDAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileUserDAO implements UserDAO {
    @Override
    public User signIn(String login, String password) throws DAOException {
        try {
            FileReader fileReader = new FileReader("users.txt");
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                if (("name = " + login).equals(scanner.nextLine())) {
                    break;
                }
            }
            if (!scanner.hasNextLine()) {
                return null;
            }

            if (scanner.nextLine().equals("password = " + password)) {
                return new User(login, true);
            } else {
                return null;
            }
        }
        catch (FileNotFoundException e){
            throw new DAOException(e);
        }
    }

    @Override
    public void signOut(User user) throws DAOException {

    }
}
