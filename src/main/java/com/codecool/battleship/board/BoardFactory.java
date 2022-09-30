package com.codecool.battleship.board;

import com.codecool.battleship.Player;
import com.codecool.battleship.Input;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareGraphics;
import com.codecool.battleship.Display;

import java.util.List;
import java.util.LinkedList;

public class BoardFactory {

    private final Display display = new Display();
    private final Input input = new Input();

    public void beginPlacement(Player player, Board board, boolean random) {
        List<Ship> ships = new LinkedList<>();
        List<Square> positions;
        Square[][] spot = board.getSpot();
        for (ShipType shipType : ShipType.values()) {
            board.display();
            positions = getShips(spot, shipType, random);
            markShips(positions);
            ships.add(new Ship(positions, shipType, player));
            player.setShips(ships);
        }
        board.display();
    }

    private List<Square> getShips(Square[][] spot, ShipType shipType, boolean random) {
        int[] firstCoord;
        if (random) {
            firstCoord = input.randomCoords();
        } else {
            display.setPlacementCoord(shipType);
            firstCoord = input.userCoord();
        }
        List<Square> shipPositions = new LinkedList<>();
        if (!isFieldEmpty(firstCoord, spot)) {
            return getShips(spot, shipType, random);
        }
        int[] direction;
        if (random) {
            direction = input.randomDirection();
        } else {
            display.chooseDirection();
            direction = input.getDirection();
        }
        Square targetSquare = spot[firstCoord[0]][firstCoord[1]];
        int i = 1;
        int[] nextCoord = new int[2];
        while (i < shipType.getLength()) {
            nextCoord[0] = firstCoord[0] + direction[0] * i;
            nextCoord[1] = firstCoord[1] + direction[1] * i;
            if (isCoordValid(nextCoord, spot) && isFieldEmpty(nextCoord, spot)) {
                placeShip(spot, nextCoord, shipPositions);
                i++;
            } else {
                display.outsideBoard();
                return getShips(spot, shipType, random);
            }
        }
        shipPositions.add(targetSquare);
        return shipPositions;
    }

    private void placeShip(Square[][] spot, int[] nextCoord, List<Square> shipPositions) {
        Square targetSquare;
        targetSquare = spot[nextCoord[0]][nextCoord[1]];
        shipPositions.add(targetSquare);
    }

    private void markShips(List<Square> shipPositions) {
        for (Square position : shipPositions) {
            position.setSquareGraphics(SquareGraphics.SHIP);
        }
    }

    public boolean isFieldEmpty(int[] inputCoord, Square[][] spot) {
        Square targetSquare = spot[inputCoord[0]][inputCoord[1]];
        return (targetSquare.getSquareGraphics() == SquareGraphics.EMPTY);
    }

    public boolean isCoordValid(int[] inputCoord, Square[][] spot) {
        int length = spot.length;
        return 0 <= inputCoord[0] && 0 <= inputCoord[1] && inputCoord[0] < length && inputCoord[1] < length;
    }
}