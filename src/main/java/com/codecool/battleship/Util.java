package com.codecool.battleship;

public class Util {
    public static String makeHeader(int size) {
        char[] letters = getLetters(size, true);
        StringBuilder header = new StringBuilder("  ");
        for (char letter : letters) {
            header.append(" ").append(letter);
        }
        StringBuilder head = header;
        header.append(" || ");
        header.append(head);
        return String.valueOf(header);
    }

    public static char[] getLetters(int count, boolean capital) {
        char[] alphabet = new char[count];
        int a;
        if(capital){
            a = 65;
        } else {
            a = 97;
        }
        for (int i = 0; i< count; i++){
            alphabet[i] = (char) (a+i);
        }
        return alphabet;
    }
}
