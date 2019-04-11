package com.javacore.Steve.command;

import java.util.ArrayList;

public class CommandHelp extends ACommand {

    public CommandHelp(String name) { super(name); }

    @Override
    public void execute() {
        ArrayList<String> listOfCommands = CommandRegistry.INSTANCE.listCommands();
        System.out.println(ANSI_YELLOW + "List of available commands: " + ANSI_RESET);
        for (String commandName: listOfCommands) {
            System.out.println(ANSI_YELLOW + commandName + ANSI_RESET);
        }
    }
}
