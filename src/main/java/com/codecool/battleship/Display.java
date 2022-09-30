package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.ship.ShipType;

public class Display {
    public void displayMenu() {
        System.out.println("1. Start game | Player vs. Player");
        System.out.println("0. Quit");
    }

    public void manualOrRandomPlacement() {
        System.out.println("1. Manual placement");
        System.out.println("2. Random placement");
    }

    public void wrongInput() {
        System.out.println("Invalid input, try again!");
    }

    public void youMissed() {
        System.out.println("You MISSED!");
    }

    public void youHit(){
        System.out.println("Nice, it's a HIT!");
    }

    public void youSunk(){
        System.out.println("Nice, you SUNK a boat!");
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void displayBoard(Square[][] spot, boolean isHidden) {
        String lettersHeader = Board.setLettersHeader(spot.length);
        System.out.println(lettersHeader);
        for (int i = 0; i < spot.length; i++) {
            StringBuilder row;
            if (i < 10) {
                row = new StringBuilder(i + " ");
            } else {
                row = new StringBuilder(i);
            }
            for (int j = 0; j < spot.length; j++) {
                if (isHidden && spot[i][j].graphic().equals("⛵")) {
                    row.append("⚫");
                } else {
                    row.append(spot[i][j].graphic());
                }
            }
            System.out.println(row);
        }
    }

    public void chooseName() {
        System.out.println("Please choose a nickname!");
    }

    public void printWinner(String player) {
        System.out.println(player + " won the game!");
    }

    public void setPlacementCoord(ShipType shipType) {
        System.out.println("Please choose a coordinate for " + shipType + " (e.g. A4). The length of this ship is: " + shipType.getLength());
    }

    public void outsideBoard() {
        System.out.println("The direction you chose is outside the board, please re-choose!");
    }



    public void chooseDirection() {
        System.out.println("Please choose the direction of the ship!");
        System.out.println("Follow the rules:");
        System.out.println("[U] - Place the ship UP");
        System.out.println("[D] - Place the ship DOWN");
        System.out.println("[R] - Place the ship to the RIGHT");
        System.out.println("[L] - Place the ship to the LEFT");
    }

    public void chooseShootingCoords() {
        System.out.println("Please choose coordinates in order to shoot!(e.g. A4)");
    }

    public void displayPlayerRound(String name) {
        System.out.println("Your turn to shoot, " + name + "!");
    }

    public void displayShotSquare() {
        System.out.println("You've already shot there, choose another spot!");
    }
}
