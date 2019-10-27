package by.epam.money.controller;

public interface Command {
    char space = ' ';
    public String execute(String request);
}
