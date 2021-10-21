package com.kodilla.rps;

import java.util.Scanner;

public class Round {
    public int userPoints = 0;
    public int computerPoints = 0;

    public void play(Computer computer, User user){
        System.out.println("Wybierz: " + System.lineSeparator() +"1 - kamien " + System.lineSeparator() + "2 - papier" + System.lineSeparator() + "3 - nozyce");
        int userMove = user.scanMove();
        int computerMove = computer.computerMove();
        Messages messages = new Messages();


        if (computerMove == 0){
            round(userMove, messages, 1, 2, 3);
        }
        else if (computerMove == 1){
            round(userMove, messages, 2,3,1);
        }
        if (computerMove == 2){
            round(userMove, messages, 3,1,2);
        }

        System.out.println("Punkty komputera: " + computerPoints);
        System.out.println("Twoje punkty: "+ userPoints);
    }

    public int chooseWinningPoints(){
        Scanner pointsToWin = new Scanner(System.in);
        return pointsToWin.nextInt();
    }

    private void round (int userMove, Messages messages, int draw, int userWins, int computerWins){
        if (userMove == draw){
            messages.draw();
        }
        else if (userMove == userWins){
            userPoints++;
            messages.youWin();
        }
        else if (userMove == computerWins){
            computerPoints++;
            messages.computerWins();
        }
        else {
            computerPoints++;
            messages.computerWins();
            messages.wrongInput();
        }
    }

}
