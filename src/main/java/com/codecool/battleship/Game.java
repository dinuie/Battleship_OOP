package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareGraphics;

public class Game {
    private boolean autoPlacement = false;
    private Player player1;
    private Player player2;
    private final Display display = new Display();
    private final Input inputs = new Input();
    private Board player1Board;
    private Board player2Board;
    private int turn = 1;
    private final BoardFactory boardFactory = new BoardFactory();
    private Board currentBoard;
    private Board enemyBoard;
    private Player currentPlayer;
    private Player enemyPlayer;

    public String getPlayerName() {
        display.chooseName();
        return inputs.userName();
    }

    public void newGame() {
        player1 = new Player(getPlayerName());
        player1Board = new Board(10);
        placeBoard(player1, player1Board);
        player2 = new Player(getPlayerName());
        player2Board = new Board(10);
        placeBoard(player2, player2Board);
        play();
    }


    private void play() {
        while (player1.isAlive() && player2.isAlive()) {
            playRound();
            turn++;
        }
        if (!player2.isAlive()) {
            display.printWinner(player1.getName());
        } else if (!player1.isAlive()) {
            display.printWinner(player2.getName());
        }
    }

    private void playRound() {
        if (turn % 2 != 0) {
            currentPlayer = player1;
            enemyPlayer = player2;
            currentBoard = player1Board;
            enemyBoard = player2Board;
        } else {
            currentPlayer = player2;
            enemyPlayer = player1;
            currentBoard = player2Board;
            enemyBoard = player1Board;
        }
        display.clearConsole();
        currentPlayer.displayRound();
        enemyBoard.setIsHidden(true);
        currentBoard.setIsHidden(false);
        currentBoard.display();
//        enemyBoard.display();
        fire();
    }

    public void fire() {
        display.chooseShootingCoords();
        int[] shoot = inputs.userCoord();
        int xCoord = shoot[0];
        int yCoord = shoot[1];
        Square targetSquare = enemyBoard.getSpot()[xCoord][yCoord];
        if (targetSquare.getSquareGraphics() == SquareGraphics.SHIP ||
                targetSquare.getSquareGraphics() == SquareGraphics.EMPTY) {
            currentPlayer.shoot(enemyPlayer, targetSquare);
        } else {
            display.displayShotSquare();
            fire();
        }
    }


    private void placeBoard(Player player, Board board) {
        display.manualOrRandom();
        int choice = inputs.userInt();
        switch (choice) {
            case 1:
                autoPlacement = false;
                break;
            case 2:
                autoPlacement = true;
                break;
            default:
                display.wrongInput();
                placeBoard(player, board);
        }
        boardFactory.beginPlacement(player, board, autoPlacement);
    }
}
