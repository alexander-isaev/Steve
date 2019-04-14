/**
 * Command Registry. All instances of command classes are storing here.
 */

package com.javacore.Steve.command;

import java.util.*;
import static com.javacore.Steve.Application.VERSION;
import static com.javacore.Steve.Application.AUTHOR;
import static com.javacore.Steve.Application.APP_NAME;
import static com.javacore.Steve.Application.ANSI_RESET;
import static com.javacore.Steve.Application.ANSI_YELLOW;

public enum CommandRegistry {
    INSTANCE;

    static Map<String, ACommand> commands;

    static {
        commands = new HashMap<>();

        // Version.
        commands.put("version", new ACommand("version") {
            @Override
            public void execute() {
                System.out.println(ANSI_YELLOW + "My version is: " + VERSION + ANSI_RESET);
            }
        });

        // Author.
        ACommand commandAuthor = new ACommand("author") {
            @Override
            public void execute() {
                System.out.println(ANSI_YELLOW + "My creator is " + AUTHOR + "." + ANSI_RESET);
            }
        };
        commands.put("creator", commandAuthor);
        commands.put("maker", commandAuthor);
        commands.put("author", commandAuthor);

        // Application Name.
        commands.put("name", new ACommand("name") {
            @Override
            public void execute() {
                System.out.println(ANSI_YELLOW + "Hi! I'm proud to say that my name is " + APP_NAME + "!" + ANSI_RESET);
            }
        });

        // Help (list of all commands).
        commands.put("help", new CommandHelp("help"));
    }

    /**
     * Check if such command exists.
     * @param name Name of the command.
     * @return True if it exists. Otherwise - false.
     */
    public boolean hasCommand (String name) {
        return commands.containsKey(name);
    }

    /**
     * Return command by it's name.
     * @param name Name of the command.
     * @return Command instance.
     */
    public ACommand getCommand(String name) {
        return commands.get(name);
    }

    /**
     * Returns list of all available commands .
     * @return ArrayList with names of all available commands.
     */
    public ArrayList<String> listCommands() {

        ArrayList<String> listOfCommands = new ArrayList<>();
        for (Map.Entry<String, ACommand> entry: commands.entrySet()) {
            listOfCommands.add(entry.getKey() + "");
        }

        return listOfCommands;
    }

}
