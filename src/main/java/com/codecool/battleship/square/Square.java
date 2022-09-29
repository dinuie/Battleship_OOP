package com.codecool.battleship.square;

public class Square {
    private final int X;
    private final int Y;
    private SquareGraphics squareGraphics;

    public Square(int x, int y) {
        X = x;
        Y = y;
        squareGraphics = SquareGraphics.EMPTY;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public SquareGraphics getSquareGraphics() {
        return squareGraphics;
    }

    public void setSquareGraphics(SquareGraphics squareGraphics) {
        this.squareGraphics = squareGraphics;
    }

    public String graphic() {
        return squareGraphics.getGraphic();
    }
}