package com.javacore.Steve;

import com.javacore.Steve.command.ACommand;
import com.javacore.Steve.command.CommandRegistry;
import com.javacore.Steve.stage.ApplicationState;
import com.javacore.Steve.stage.StateIdle;

/**
 * Project for JavaCore course.
 * @author Alexander Isaev
 * @version 0.0.1
 */
public class Application {

     static public final String APP_NAME = "Steve";
     static public final String AUTHOR = "Alexander Isaev";
     static public final String VERSION = "0.0.2";

     static ApplicationState currentState;

    public static void main(String[] args) {

        changeState(new StateIdle(), "Idle");
        String commandName = "version"; // We enter command name (in console in future) to execute it.
        currentState.onCommand(commandName);

        currentState.onCommand("author");
        currentState.onCommand("help");
    }

    public static void changeState(ApplicationState newState, String commandName) {
        if (currentState != null)
            currentState.exit();

        currentState = newState;
        currentState.enter(commandName);
    }


}
