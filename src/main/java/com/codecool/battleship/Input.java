package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.ship.Coordinate;

import java.util.Random;
import java.util.Scanner;

public class Input {

    private final Display display = new Display();

    Scanner userInput = new Scanner(System.in);

    public String userName() {
        String input = userInput.nextLine();
        if (isValidNameInput(input)) {
            return input;
        }
        return userName();
    }

    public int[] getDirection() {
        String input = userInput.nextLine();
        int[] direction;
        switch (input.toLowerCase()) {
            case "u":
                direction = Coordinate.UP.getCoords();
                return direction;
            case "d":
                direction = Coordinate.DOWN.getCoords();
                return direction;
            case "r":
                direction = Coordinate.RIGHT.getCoords();
                return direction;
            case "l":
                direction = Coordinate.LEFT.getCoords();
                return direction;
            default:
                display.wrongInput();
                return getDirection();
        }
    }

    public int userInt() {
        String input = userInput.nextLine();
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
            display.wrongInput();
            return false;
        }
    }

    public int[] userCoord() {
        char[] abc = Board.getLetters(10, false);
        String move = userInput.nextLine();
        char[] startCoord = move.toCharArray();
        if (!isCoordInputValid(startCoord)) {
            display.wrongInput();
            return userCoord();
        }
        int firstCoord = convertFirstCoord(startCoord[0], abc);
        int secondCoord = convertSecondCoord(startCoord, abc);
        if (firstCoord < 0 || secondCoord < 0) {
            display.wrongInput();
            return userCoord();
        }
        int[] startCoords = new int[2];
        startCoords[1] = firstCoord;
        startCoords[0] = secondCoord;
        return startCoords;
    }

    public int convertFirstCoord(char coord, char[] abc) {
        coord = Character.toLowerCase(coord);
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


    public int convertSecondCoord(char[] coords, char[] abc) {
        String convertCoord;
        if (coords.length > 2) {
            convertCoord = String.valueOf(coords[1]) + coords[2];
        } else {
            convertCoord = String.valueOf(coords[1]);
        }
        int coo = Integer.parseInt(convertCoord);
        if (coo < abc.length) {
            return coo;
        }
        return -1;
    }

    public boolean isCoordInputValid(char[] coords) {
        if (coords.length < 2 || coords.length > 3) {
            return false;
        } else if (coords.length == 3) {
            return Character.isDigit(coords[1]) && Character.isDigit(coords[2]);
        } else return Character.isDigit(coords[1]);
    }

    public boolean isValidNameInput(String name) {
        return name.length() <= 10;
    }

    public int[] randomCoords() {
        int[] startCoord = new int[2];
        startCoord[0] = new Random().nextInt(10);
        startCoord[1] = new Random().nextInt(10);
        return startCoord;
    }

    public int[] randomDirection() {
        return Coordinate.values()[new Random().nextInt(Coordinate.values().length)].getCoords();
    }
}