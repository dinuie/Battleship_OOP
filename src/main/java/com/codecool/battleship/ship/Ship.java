package com.codecool.battleship.ship;

import java.util.List;

import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareGraphics;
import com.codecool.battleship.Player;

public class Ship {
    private List<Square> position;
    private ShipType shipType;
    private Player player;
    private boolean isSunk;

    public Ship(List<Square> position, ShipType shipType, Player player) {
        this.position = position;
        this.shipType = shipType;
        this.player = player;
        this.isSunk = false;
    }


    public Player getPlayer() {
        return player;
    }


    public boolean getSunk() {
        return isSunk;
    }

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }

    public List<Square> getPosition() {
        return position;
    }

    public boolean isSunk() {
        for (Square square : this.position) {
            if (square.getSquareGraphics() == SquareGraphics.SHIP) {
                return false;
            }
        }
        return true;
    }

}