package com.codecool.battleship;

import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareStatus;

import java.util.Arrays;
import java.util.List;

public class Player {
    private List<Ship> ships;
    private String name;

    public Player(List<Ship> ships, String name) {
        this.ships = ships;
        this.name = name;
    }

    public void shoot(Player enemyPlayer, int x, int y) {
        for (Ship ship : enemyPlayer.ships) {
            for (Square pos : ship.getPosition()) {
                if (pos.getX() == x && pos.getY() == y && pos.getSquareStatus() != SquareStatus.HIT && pos.getSquareStatus() != SquareStatus.SUNK) {
                    pos.getSquareStatus(SquareStatus.HIT);
                }
            }
        }
    }

    public boolean isAlive(List<Ship> ships){
        int playerALlShipNumber = ships.size();
        int playerSunkShipsNumber = 0;
        for (Ship ship : ships){
            if(ship.getSunk()){
                playerSunkShipsNumber++;
            }
        }
        return playerALlShipNumber != playerSunkShipsNumber;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Ship> getShips(){
        return ships;
    }
}
