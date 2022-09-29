package com.codecool.battleship.ship;

public enum Coordinate {
    UP(-1, 0),
    DOWN(1, 0),
    RIGHT(0, 1),
    LEFT(0, -1);

    private final int x;
    private final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getCoords() {
        int[] coords = new int[2];
        coords[0] = this.x;
        coords[1] = this.y;
        return coords;
    }
}
