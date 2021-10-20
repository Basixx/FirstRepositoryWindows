package com.kodilla.rps;

import java.util.Random;

public class Computer {
    public int computerMove(){
        Random generator = new Random();

        // 1 - Rock
        // 2 - Paper
        // 3 - Scissors

        int computerMove = generator.nextInt(3);

        if (computerMove == 0) System.out.println("Komputer wybrał kamień");
        else if (computerMove == 1) System.out.println("Komputer wybrał papier");
        else  System.out.println("Komputer wybrał nożyce");
        return computerMove;
    }

}
