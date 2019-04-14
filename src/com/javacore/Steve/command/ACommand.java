package com.javacore.Steve.command;

import static com.javacore.Steve.Application.ANSI_RESET;
import static com.javacore.Steve.Application.ANSI_YELLOW;

public abstract class ACommand {

    protected String name;
    protected String description;

    public ACommand(String name) { // Super-class constructor.
        this.name = name;
    }

    public void execute() { // Default method
        System.out.println(ANSI_YELLOW + "Command " + name + " not implemented" + ANSI_RESET);
    }


}
