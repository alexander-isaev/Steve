package com.javacore.Steve.stage;

import com.javacore.Steve.Application;
import com.javacore.Steve.command.CommandRegistry;

public class StateExecutingCommand extends ApplicationState {

    @Override
    public void enter(String commandName) {
        System.out.println("Entering state <<Executing command>>: " + commandName);
        executeCommand(commandName);
    }

    private void executeCommand(String commandName) {
        if (CommandRegistry.INSTANCE.hasCommand(commandName))
            CommandRegistry.INSTANCE.getCommand(commandName).execute();
        else
            System.out.println("No such command available!");

        if (!commandName.equals("exit")) {
            Application.changeState(new StateIdle(), "Idle");
        }
    }

    @Override
    public void onCommand(String commandName) {
        System.out.println("Busy executing " + commandName);
    }

    @Override
    public void exit() {
        System.out.println("Exiting command execution...");
    }
}
