package com.codecool.battleship;

public class Display {
    public void displayMenu() {
        System.out.println("1. Start a new game");
        System.out.println("0. Exit");
    }

    public void wrongInput() {
        System.out.println("Invalid input, try again!");
    }
}
