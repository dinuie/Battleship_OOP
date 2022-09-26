package com.codecool.battleship.ship;

public enum Coordinate {
    NORTH(-1, 0),
    SOUTH(1, 0),
    EAST(0, 1),
    WEST(0, -1);
    private final int x;
    private final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getCoord() {
        int[] coord = new int[2];
        coord[0] = this.x;
        coord[1] = this.y;
        return coord;
    }
}
