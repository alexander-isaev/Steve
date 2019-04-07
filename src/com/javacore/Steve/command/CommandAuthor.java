package com.javacore.Steve.command;

import static com.javacore.Steve.Application.AUTHOR;

public class CommandAuthor extends ACommand {

    public CommandAuthor(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("My creator is " + AUTHOR + ".");
    }
}
