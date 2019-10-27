package by.epam.money.controller;

import by.epam.money.controller.impl.CommandProvider;

public class Controller {
    private final CommandProvider provider = new CommandProvider();
    private final char space = ' ';

    public String executeTask(String request){
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(space));
        executionCommand = provider.getCommand(commandName);
        request = request.substring(request.indexOf(space) + 1);

        String response;
        return response = executionCommand.execute(request);
    }
}
