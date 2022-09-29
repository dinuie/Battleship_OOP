package com.codecool.battleship.square;

public enum SquareGraphics {
    SHIP("⛵"),
    EMPTY("⚫"),
    HIT("\uD83C\uDFAF"),
    MISSED("\uD83D\uDE22"),
    SUNK("\uD83D\uDC80");

    private final String graphic;

    SquareGraphics(String graphic) {
        this.graphic = graphic;
    }

    public String getGraphic() {
        return graphic;
    }
}

