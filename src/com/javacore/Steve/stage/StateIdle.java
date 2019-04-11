package com.javacore.Steve.stage;

import com.javacore.Steve.Application;

public class StateIdle extends ApplicationState {

    @Override
    public void enter(String commandName) {
        System.out.println("Entering <<Idle>> state...");
    }

    @Override
    public void onCommand(String commandName) {
        System.out.println("New command received, staring execution: " + commandName);
        Application.changeState(new StateExecutingCommand(), commandName);
    }

    @Override
    public void exit() {
        System.out.println("Exiting Idle state.");
    }
}
