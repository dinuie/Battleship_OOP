package com.codecool.battleship.square;

public class Square {
    private final int X;
    private final int Y;
    private SquareStatus squareStatus;

    public Square(int x, int y) {
        X = x;
        Y = y;
        squareStatus = SquareStatus.EMPTY;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }

    public void setSquareStatus(SquareStatus squareStatus) {
        this.squareStatus = squareStatus;
    }

    public String graphic() {
        String square;
        switch (squareStatus) {
            case SHIP:
                square = "\t\uD83D\uDEA2";
                break;
            case HIT:
                square = "\uD83D\uDD25";
                break;
            case MISSED:
                square = "\uD83D\uDCA7";
                break;
            case SUNK:
                square = "\uD83C\uDF0A";
                break;
            case EMPTY:

            default:
                square = "\t\uD83C\uDF2B";
                break;
        }
        return square;
    }
}
