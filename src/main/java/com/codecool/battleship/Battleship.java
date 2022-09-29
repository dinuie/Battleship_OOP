package com.codecool.battleship;

public class Battleship {
    private Display display;
    private Input inputs;
    private Game game;
    public boolean run;

    private Battleship() {
        display = new Display();
        inputs = new Input();
        game = new Game();
        run = true;
    }

    private void mainMenu() {
        while (run) {
            display.displayMenu();
            int chosenMode = inputs.userInt();
            switch (chosenMode) {
                case 0:
                    run = false;
                    break;
                case 1:
                    game.newGame();
                    break;
                default:
                    display.wrongInput();
                    mainMenu();
            }
        }
    }

    public static void main(String args[]) {
        new Battleship().mainMenu();
    }
}

