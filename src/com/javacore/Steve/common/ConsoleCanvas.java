package com.javacore.Steve.common;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Draws screen.
     */
    public void draw() {
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(pixels[i][j]);
            }
        }
        System.out.println();
    }

    // Set symbol at coordinates at screen.
    public void setSymbolAt(int x, int y, char symbol) {
        pixels[y][x] = symbol;
    }

    public boolean hasSymbolAt(int x, int y) {
        if (pixels[y][x] == '.')
            return false;
        else
            return true;
    }

    @Override
    public void drawText(String text) {
        System.out.println(text);
    }

    /**
     * Sets square at x, y coordinates, where (x,y) - upper left angle.
     * @param x x coordinate.
     * @param y y coordinate.
     * @param size Length of the side of a square.
     */
    public void setSquareAt(int x, int y, int size) {
        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1){
                for (int j = 0; j < size; j++) {
                    setSymbolAt(x, y, '#');
                    x++;
                }

            } else {
                setSymbolAt(x, y, '#');
                x++;
                for (int j = 0; j < size - 2; j++) {
                    x++;
                }
                setSymbolAt(x, y, '#');
                x++;
            }
            y++;
            x -= size;
        }
    }

    public void setCircleAt(int x, int y, int radius) {
        if (radius >= 10)
            radius = 9;
        if (radius <= 1)
            radius = 1;

        int diameter = radius * 2;
        int stringsNumber = 1;

        // Узнаем кол-во строк.
        for (int i = 1; i <= radius; i++) {
            if ((i - 1) % 3 == 0) {
                stringsNumber += 2;
            }
        }

        // Узнаем кол-во символов круга в каждой строке.
        int[] lengthOfStrings = new int[stringsNumber];
        int middleString = stringsNumber/2;
        int length = diameter;
        int plusToLowerString = 2;
        int factor= 1;
        lengthOfStrings[middleString] = length;
        for (int i = middleString - 1; i >= 0; i--) {
            length = length - 2*factor;
            lengthOfStrings[i] = length;
            lengthOfStrings[i + plusToLowerString] = length;
            plusToLowerString += 2;
            factor++;
        }

        int numberOfPoints;
        for (int i = 0; i < stringsNumber; i++) {
            numberOfPoints = (diameter - lengthOfStrings[i])/2;
            // Если первая или последняя строка.
            if (i == 0 || i == stringsNumber - 1) {
                for (int j = 0; j < lengthOfStrings[i]; j++) {
                    setSymbolAt(x + numberOfPoints, y, '#');
                    x++;
                }
                x -= lengthOfStrings[i];
            } else {
                setSymbolAt(x + numberOfPoints, y, '#');
                setSymbolAt(x + numberOfPoints + (lengthOfStrings[i] - 1), y, '#');
            }

            y++;
        }
    }

    /**
     * Sets text in canvas coordinates.
     * @param x x
     * @param y y
     * @param text Any text
     * @return Current string number (y value).
     */
    public int setTextAt(int x, int y, String text) {
        char[] textInChar = text.toCharArray();
        int leftField = x;

        for (char character: textInChar) {
            if (x >= width - 2 || hasSymbolAt(x + 2, y)) {
                y++;
                x = leftField;
            }

            if (character == '\n') {
                y++;
                x = leftField;
                continue;
            }

            if (y >= height)
                return y;

            setSymbolAt(x, y, character);
            x++;
        }

        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
