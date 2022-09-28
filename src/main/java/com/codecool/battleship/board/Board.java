package com.codecool.battleship.board;

import com.codecool.battleship.square.Square;

public class Board {
    Square[][] ocean;

    public Board(int boardSize) {
        ocean = new Square[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                ocean[i][j] = new Square(i,j);
            }
        }
    }

    public void isPlacementOk(){

    }
}
