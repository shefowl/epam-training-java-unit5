package by.epam.money;


import by.epam.money.bean.Account;
import by.epam.money.controller.Controller;
import by.epam.money.dao.AccountDAO;
import by.epam.money.dao.DAOException;
import by.epam.money.dao.DAOFactory;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.executeTask("SIGN_IN admin 1234").equals("Welcome");
        controller.executeTask("CREATE_ACCOUNT 45467");
        System.out.println(controller.executeTask("READ_ACCOUNT 3"));
        controller.executeTask("DELETE_ACCOUNT 3");
        controller.executeTask("UPDATE_ACCOUNT 2 546");
    }
}

