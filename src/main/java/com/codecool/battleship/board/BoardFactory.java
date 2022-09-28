package com.codecool.battleship.board;
import com.codecool.battleship.Player;
import com.codecool.battleship.Input;
import com.codecool.battleship.ship.Ship;

public class BoardFactory {
    public void placement(Player player, Input input) {
        ships = player.ships;
        for (Ship ship : ships) {
            int[] startingCoord = input.coordInput();
            if (isValidCoord(startingCoord)) {
                if (ship.location.length = 1) {
                    ship.location[0].x = startingCoord[0];
                    ship.location[1].x = startingCoord[1];
                }
            }
        }
    }

    public boolean isValidCoord(int[] inputCoord) {
        for (Square square : board.ocean) {
            if (square.x = inputCoord[0] || square.y = inputCoord[1]) {
                return true;
            }
        }
        return false;
    }
}
