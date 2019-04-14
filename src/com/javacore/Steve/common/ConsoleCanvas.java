package com.javacore.Steve.common;

public class ConsoleCanvas extends Canvas {

    @Override
    public void drawText(String text) {
        System.out.println(text);
    }

    @Override
    public void drawSquare(int size) {
        System.out.println();
        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1) {
                for (int j = 0; j < size; j++) {
                    System.out.print("#");
                }
                System.out.println();
            }

            else {
                System.out.print("#");
                for (int j = 0; j < size - 2; j++) {
                    System.out.print(" ");
                }
                System.out.println("#");

            }
        }
    }
}
