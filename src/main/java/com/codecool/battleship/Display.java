package com.codecool.battleship;

import com.codecool.battleship.Util;
import com.codecool.battleship.square.Square;

public class Display {
    public void displayMenu() {
        System.out.println("1. Start a new game");
        System.out.println("0. Exit");
    }

    public void wrongInput() {
        System.out.println("Invalid input, try again!");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void displayBoards(Square[][] ocean1, Square[][] ocean2) {
        String header = Util.makeHeader(ocean1.length);
        System.out.println(header);
        for (int i = 0; i < ocean1.length; i++) {
            StringBuilder board1;
            if (i < 10) {
                board1 = new StringBuilder(" " + i);
            } else {
                board1 = new StringBuilder(i);
            }
            StringBuilder board2 = new StringBuilder(" ");
            for (int j = 0; j < ocean1.length; j++) {
                board1.append(ocean1[i][j].graphic()).append(" ");
                board1.append(ocean2[i][j].graphic()).append(" ");
            }
            if (i < 10) {
                board2.append(" ").append(i);
            } else {
                board2.append(i);
            }
            board1.append(" || ");
            board1.append(board2);
            System.out.println(board1);
        }
    }
}
