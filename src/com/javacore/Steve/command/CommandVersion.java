package com.javacore.Steve.command;

import static com.javacore.Steve.Application.VERSION;

public class CommandVersion extends ACommand {

    public  CommandVersion(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("My version is: " + VERSION);
    }
}
