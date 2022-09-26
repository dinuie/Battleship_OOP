package com.codecool.battleship;
import com.codecool.battleship.Input;
import com.codecool.battleship.Display;

public class Battleship {
    private static Display display;
    private static Input inputs;
    private static Game game;
    private static boolean run;

    private Battleship(){
        display = new Display();
        inputs = new Input();
        game = new Game();
        run = true;
    }

    private static void mainMenu(){
        display.menuDisplay();
        int chosenMode = inputs.menuInput();
        switch (chosenMode){
            case 0:
                game.newGame();
            case 1:
                run = false;
                break;
        }
    }

    public static void main(String args[]){
        while(run){
        mainMenu();
        }
    }
}
