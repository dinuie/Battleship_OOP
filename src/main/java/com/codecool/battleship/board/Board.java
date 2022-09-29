package com.codecool.battleship.board;

import com.codecool.battleship.square.Square;
import com.codecool.battleship.Display;

public class Board {
    private Square[][] spot;
    private boolean isHidden = false;
    private Display display = new Display();


    public Board(int boardSize) {
        spot = new Square[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                spot[i][j] = new Square(i, j);
            }
        }
    }

    public Square[][] getSpot() {
        return spot;
    }

    public static char[] getLetters(int count, boolean capital) {
        char[] alphabet = new char[count];
        int a;
        if (capital)
            a = 65;
        else
            a = 97;
        for (int i = 0; i < count; i++) {
            alphabet[i] = (char) (a + i);
        }
        return alphabet;
    }

    public static String setLettersHeader(int size) {
        char[] letters = getLetters(size, true);
        StringBuilder lettersHeader = new StringBuilder();
        lettersHeader.append("   ");
        for (char letter : letters) {
            lettersHeader.append(String.format(letter + " "));
        }
        return lettersHeader.toString();
    }

    public void setIsHidden(boolean isItHidden) {
        this.isHidden = isItHidden;
    }

    public void display() {
        display.displayBoard(spot, isHidden);
    }
}
