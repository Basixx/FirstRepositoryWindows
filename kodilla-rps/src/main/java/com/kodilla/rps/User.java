package com.kodilla.rps;

import java.util.Scanner;

public class User {

    public int scanMove(){
        Scanner scannedMove = new Scanner(System.in);
        int move = scannedMove.nextInt();
        if(move == 1) System.out.println("Wybrano kamień");
        else if (move ==2) System.out.println("Wybrano papier");
        else if (move ==3) System.out.println("Wybrano nożyce");
        return move;
    }
}
