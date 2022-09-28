package com.codecool.battleship;

import com.codecool.battleship.Display;
import com.codecool.battleship.Input;
import com.codecool.battleship.Player;
import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
import com.codecool.battleship.square.Square;

public class Game {
    private Player firstPlayer;
    private Player secondPlayer;
    private Display display;
    private Input inputs;
    private Board board;
    private int turn;
    private boolean hasWon;
    private String name;

    private int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    private Game() {
        hasWon = false;
        turn = 1;
        board = new Board(10);
        display = new Display();
        inputs = new Input();
    }

    private void newGame() {
        display.provideName();
        name = inputs.userName();
        placeBoard();
        firstPlayer = new Player(firstPlayer.getShips(), name);
        display.provideName();
        name = inputs.userName();
        secondPlayer = new Player(secondPlayer.getShips(), name);
        display.boardFactory();
        play();
    }

    private void play() {
        while (!hasWon) {
            turn = getTurn();
            if (turn % 2 == 0) {
                playRound(firstPlayer, secondPlayer);
                if (enemyHasLost(secondPlayer)) {
                    display.printWinner(firstPlayer);
                    hasWon = true;
                }
            } else {
                playRound(secondPlayer, firstPlayer);
                if (enemyHasLost(firstPlayer)) {
                    display.printWinner(secondPlayer);
                    hasWon = true;
                }
            }
            setTurn(turn + 1);
        }
    }

    private void playRound(Player currentPlayer, Player enemyPlayer) {
        Square[][] table = board.getOcean();
        display.printEnemyTable();
        int[] shoot = inputs.coordInput();
        int xCoord = shoot[0];
        int yCoord = shoot[1];
        currentPlayer.shoot(enemyPlayer, xCoord, yCoord);
        board.setOcean(table);
        display.printEnemyTable();
    }

    private boolean enemyHasLost(Player enemyPlayer) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == enemyPlayer) {
                    return false;
                }
            }
        }
        return true;
    }

    private void placeBoard() {
        int choice = inputs.userInt();
        if (choice == 1) {
            BoardFactory manual;
        } else {
            BoardFactory random;
        }
    }
}
