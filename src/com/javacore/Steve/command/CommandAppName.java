package com.javacore.Steve.command;

import static com.javacore.Steve.Application.APP_NAME;

public class CommandAppName extends ACommand {

    public CommandAppName(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("Hi! I'm proud to say that my name is " + APP_NAME + "!");
    }
}
