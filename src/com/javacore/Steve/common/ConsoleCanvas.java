package com.javacore.Steve.common;

public class ConsoleCanvas extends Canvas {

    private char[][] pixels;
    private int width;
    private int height;

    public ConsoleCanvas(int width, int height) {
        this.height = height;
        this.width = width;
        init();
    }

    public void init() {
        pixels = new char[height][width];
        reset();
    }

    private void reset() {
        for (int i = 0; i <  height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = '.';
            }

        }
    }

    public void draw() {
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(pixels[i][j]);
            }
        }
    }

    // Set symbol at coordinates at screen.
    public void setSymbolAt(int x, int y, char symbol) {
        pixels[x][y] = symbol;
    }

    @Override
    public void drawText(String text) {
        System.out.println(text);
    }

    public void drawSquareAt(int x, int y, int size) {
        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1){
                for (int j = 0; j < size; j++) {
                    setSymbolAt(x, y, '#');
                    y++;
                }

            } else {
                setSymbolAt(x, y, '#');
                y++;
                for (int j = 0; j < size - 2; j++) {
                    y++;
                }
                setSymbolAt(x, y, '#');
                y++;
            }
            x++;
            y -= size;

        }

        draw();
    }

    // TODO: Make library with these methods:

    @Override
    public void drawSquare(int size) {

    }

    public void drawCircleAt(int x, int y, int radius) {

    }

    // TODO: Text must move between the lines.
    public void drawTextAt(int x, int y, String text) {

    }
}
