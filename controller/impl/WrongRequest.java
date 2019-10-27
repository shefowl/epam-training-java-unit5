package by.epam.money.controller.impl;

import by.epam.money.controller.Command;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) {
        return "Wrong request";
    }
}
