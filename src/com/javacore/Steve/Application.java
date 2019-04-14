package com.javacore.Steve;

import com.javacore.Steve.profile.ProfileController;
import com.javacore.Steve.stage.ApplicationState;
import com.javacore.Steve.stage.StateIdle;
import java.util.Scanner;

/**
 * Project for JavaCore course.
 * @author Alexander Isaev
 * @version 0.0.2
 */
public class Application {

    static public final String APP_NAME = "Steve";
    static public final String AUTHOR = "Alexander Isaev";
    static public final String VERSION = "0.0.2";

    static public final String ANSI_YELLOW = "\u001B[33m";
    static public final String ANSI_RESET = "\u001B[0m";
    static public final String ANSI_BLUE = "\u001B[34m";

    static ApplicationState currentState;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String commandName;
        changeState(new StateIdle(), "Idle");

        do {
            System.out.print(ANSI_BLUE + "Me: ");
            commandName = in.nextLine();
            System.out.print(ANSI_RESET);

            currentState.onCommand(commandName);
        } while (!commandName.equals("exit"));
        // TODO: Exit command.

        // TODO: It should be a new command, this part shouldn't be here.
        System.out.println();
        ProfileController profileController = new ProfileController();
        profileController.showProfile(7);
    }

    public static void changeState(ApplicationState newState, String commandName) {
        if (currentState != null)
            currentState.exit();

        currentState = newState;
        currentState.enter(commandName);
    }
}
