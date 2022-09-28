package com.codecool.battleship;
import com.codecool.battleship.Input;
import com.codecool.battleship.Display;

public class Battleship {
    private Display display;
    private Input inputs;
    public boolean run;

    private Battleship(){
        display = new Display();
        inputs = new Input();
//        game = new Game();
        run = true;
    }

    public void mainMenu(){
        while(run){
            display.displayMenu();
            int chosenMode = inputs.userInt();
            switch(chosenMode){
                case 0:
                    run = false;
                    break;
                case 1:
                    System.out.println("Start a new game");
                    break;
                default:
                    display.wrongInput();
                    mainMenu();
            }
        }
    }

    public static void main(String args[]){
        new Battleship().mainMenu();
    }
}
