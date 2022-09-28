package com.codecool.battleship.board;
import com.codecool.battleship.Input;

public class BoardFactory {
    public void placement(Player player){
        ships = player.ships;
        for (Ship ship : ships){
            int[] startingCoord = Input.coordInput();
            if (isValidCoord(startingCoord)){
                if (ship.location.length = 1){
                    ship.location[0].x = startingCoord[0];
                    ship.location[1].x = startingCoord[1];
                }
            }
        }
    }

    public boolean isValidCoord(int[] inputCoord){
        for (Square square : board.ocean){
            if(square.x = inputCoord[0] || square.y = inputCoord[1]){
                return true;
            }
        }
        return false;
    }
}
