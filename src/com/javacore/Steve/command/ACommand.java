package com.javacore.Steve.command;

public abstract class ACommand {

    // Colors for strings:
    protected static final String ANSI_YELLOW = "\u001B[33m";
    protected static final String ANSI_RESET = "\u001B[0m";

    protected String name;
    protected String description;

    public ACommand(String name) { // Super-class constructor.
        this.name = name;
    }

    public void execute() { // Default method
        System.out.println(ANSI_YELLOW + "Command " + name + " not implemented" + ANSI_RESET);
    }


}
