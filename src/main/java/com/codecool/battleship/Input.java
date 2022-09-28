package com.codecool.battleship;

import com.codecool.battleship.Util;

import java.util.Scanner;

public class Input {
    Scanner userInput = new Scanner(System.in);

    public int userInt() {
        String input = "";
        while (!isInt(input)) {
            input = userInput.nextLine();
        }
        return Integer.parseInt(input);
    }

    private boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (
                NumberFormatException e) {
            return false;
        }

    }

    public int[] coordInput() {
        char[] abc = Util.getLetters(10, false);
        String move = userInput.nextLine();
        char[] startingCoord = move.toCharArray();
        if (!validInput(startingCoord)) {
            return coordInput();
        }
        int firstCoord = convertFirstCoord(startingCoord[0], abc);
        int secondCoord = convertSecordCoord(startingCoord, abc);
        if (firstCoord < 0 || secondCoord < 0) {
            return coordInput();
        }
        int[] startingCoord = new int[2];
        startingCoord[0] = firstCoord;
        startingCoord[1] = secondCoord;
        return startingCoord;
    }

    public int convertFirstCoord(char coord, char[] abc) {
        coord = Character.toUpperCase(coord);
        int firstCoord = 0;
        boolean found = false;
        for (int i = 0; i < abc.length; i++) {
            if (abc[i] == coord) {
                firstCoord = i;
                found = true;
            }
        }
        if (found) {
            return firstCoord;
        }
        return -1;
    }

    public int convertSecordCoord(char[] coords, char[] abc) {
        String convertCoord;
        if (coords.length > 2) {
            convertCoord = String.valueOf(coords[1]) + coords[2];
        } else {
            convertCoord = String.valueOf(coords[1]);
        }
        int coord = Integer.parseInt(convertCoord) - 1;
        if (coord < abc.length) {
            return coord;
        }
        return -1;
    }

    public boolean validInput(char[] coords) {
        if (coords.length < 2 || coords.length > 3) {
            return false;
        } else if (coords.length == 3) {
            return Character.isDigit(coords[1]) && Character.isDigit(coords[2]);
        } else return Character.isDigit(coords[1]);
    }
}
