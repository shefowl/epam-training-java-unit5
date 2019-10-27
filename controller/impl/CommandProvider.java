package by.epam.money.controller.impl;

import by.epam.money.controller.Command;
import by.epam.money.controller.CommandName;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.CREATE_ACCOUNT, new CreateAccount());
        repository.put(CommandName.READ_ACCOUNT, new ReadAccount());
        repository.put(CommandName.UPDATE_ACCOUNT, new UpdateAccount());
        repository.put(CommandName.DELETE_ACCOUNT, new DeleteAccount());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());

    }

    public Command getCommand(String name){
        CommandName commandName =null;
        Command command = null;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }catch(IllegalArgumentException | NullPointerException e){
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }

}
