package com.codecool.battleship;

import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareGraphics;

import java.util.List;

public class Player {
    private Display display = new Display();
    private List<Ship> ships;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void shoot(Player enemyPlayer, Square targetSquare) {
        for (Ship ship : enemyPlayer.ships) {
            for (Square pos : ship.getPosition()) {
                if (pos == targetSquare) {
                    display.youHit();
                    pos.setSquareGraphics(SquareGraphics.HIT);
                    if (ship.isSunk()) {
                        display.youSunk();
                        markSunk(ship);
                    }
                    break;
                }
            }
        }
        if (targetSquare.getSquareGraphics() == SquareGraphics.EMPTY) {
            display.youMissed();
            targetSquare.setSquareGraphics(SquareGraphics.MISSED);
        }
    }

    private void markSunk(Ship ship) {
        for (Square square : ship.getPosition()) {
            square.setSquareGraphics(SquareGraphics.SUNK);
        }
        ship.setSunk(true);
    }

    public boolean isAlive() {
        for (Ship ship : ships) {
            if (!ship.getSunk()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public void displayRound() {
        display.displayPlayerRound(name);
    }
}
