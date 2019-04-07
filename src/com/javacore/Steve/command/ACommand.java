package com.javacore.Steve.command;

public abstract class ACommand {
    protected  String name;
    protected  String description;

    public ACommand(String name) { // Super-class constructor.
        this.name = name;
    }

    public void execute() { // Default method
        System.out.println("Command " + name + " not implemented");
    }


}
