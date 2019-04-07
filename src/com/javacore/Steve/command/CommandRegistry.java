package com.javacore.Steve.command;

import java.util.*;

public enum CommandRegistry {

    INSTANCE;

    static Map<String, ACommand> commands; // Do command by it's key.

    static {
        commands = new HashMap<>();

        commands.put("version", new CommandVersion("version"));
        CommandAuthor commandAuthor = new CommandAuthor("author"); // To make ability to call method with different names in input.
        commands.put("creator", commandAuthor);
        commands.put("maker", commandAuthor);
        commands.put("author", commandAuthor);
        commands.put("name", new CommandAppName("name"));
        commands.put("help", new CommandHelp("help"));
    }

    // Check if such command like @name exists.
    public boolean hasCommand (String name) {
        return commands.containsKey(name);
    }

    // Return command by name.
    public ACommand getCommand(String name) {
        return commands.get(name);
    }

    // Shows list of commands available.
    public ArrayList<String> listCommands() {

        ArrayList<String> listOfCommands = new ArrayList<>();
        for (Map.Entry<String, ACommand> entry: commands.entrySet()) {
            listOfCommands.add(entry.getKey() + "");
        }

        return listOfCommands;
    }
}
