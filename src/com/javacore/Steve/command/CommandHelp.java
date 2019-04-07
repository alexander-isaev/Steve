package com.javacore.Steve.command;

import java.util.ArrayList;

public class CommandHelp extends ACommand {

    public CommandHelp(String name) { super(name); }

    @Override
    public void execute() {
        ArrayList<String> listOfCommands = CommandRegistry.INSTANCE.listCommands();
        System.out.println("List of available commands: ");
        for (String commandName: listOfCommands) {
            System.out.println(commandName);
        }
    }
}
