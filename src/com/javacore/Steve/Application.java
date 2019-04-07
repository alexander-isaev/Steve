package com.javacore.Steve;

import com.javacore.Steve.command.ACommand;
import com.javacore.Steve.command.CommandRegistry;

public class Application {

     static public final String APP_NAME = "Steve";
     static public final String AUTHOR = "Alexander Isaev";
     static public final String VERSION = "0.0.1";

    public static void main(String[] args) {

        String commandName = "version"; // We enter command name (in console in future) to execute it.
        ACommand command = CommandRegistry.INSTANCE.getCommand(commandName); // We get command from Singleton and initialize our abstract command instance by it.
        command.execute();

        command = CommandRegistry.INSTANCE.getCommand("author");
        command.execute();

        command = CommandRegistry.INSTANCE.getCommand("name");
        command.execute();

        command = CommandRegistry.INSTANCE.getCommand("help");
        command.execute();

    }




}
