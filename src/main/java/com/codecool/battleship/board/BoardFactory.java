package com.codecool.battleship.board;

import com.codecool.battleship.Player;
import com.codecool.battleship.Input;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareStatus;

import java.util.List;

public class BoardFactory {
    public void manualPlacement(Player player, Board board, Input input) {
        List<Ship> ships = player.getShips();
        Square[][] ocean = board.getOcean();
        for (Ship ship : ships) {
            int[] startingCoord = input.coordInput();
            if (isValidCoord(startingCoord, ocean) && isEmptyField(startingCoord, ocean)) {

            }
        }
    }

    public boolean isValidCoord(int[] inputCoord, Square[][] ocean) {
        int length = ocean.length;
        return 0 <= inputCoord[0] && 0 <= inputCoord[1] && inputCoord[0] <= length && inputCoord[1] <= length;
    }

    public boolean isEmptyField(int[] inputCoord, Square[][] ocean){
        Square targetSquare = ocean[inputCoord[0]][inputCoord[1]];
        return (targetSquare.getSquareStatus() == SquareStatus.EMPTY);
    }
}
