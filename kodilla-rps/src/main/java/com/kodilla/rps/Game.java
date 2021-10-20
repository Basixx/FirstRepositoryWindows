package com.kodilla.rps;

import java.util.Scanner;

public class Game {
    public void playWholeGame(){
        Computer computer = new Computer();
        User user = new User();
        Round round = new Round();
        int roundNumber = 1;
        System.out.println("wybierz do ilu gracie");
        int pointsToWin = round.chooseWinningPoints();

        while (round.userPoints < pointsToWin && round.computerPoints < pointsToWin){

            System.out.println("Runda numer "+ roundNumber);

            round.play(computer, user);
            roundNumber++;
            System.out.println(System.lineSeparator());
        }
        if (round.computerPoints == pointsToWin) System.out.println("Zwyciężył komputer");
        else if (round.userPoints == pointsToWin) System.out.println("Brawo! Wygrałeś!");
        playAgain();

    }

    public void playAgain(){
        System.out.println("Czy chcesz grać jeszcze raz? Wybierz:"  + System.lineSeparator() + "n - gramy jeszcze raz" + System.lineSeparator() + "x - kończymy na dziś");
        Scanner ifPlays = new Scanner(System.in);
        char move = ifPlays.next().charAt(0);
        while (true)
            if (move == 'n') {
                System.out.println("Ok! gramy jeszcze raz");
                playWholeGame();
            } else if (move == 'x') {
                System.out.println("Kończymy na dziś. Dzięki za grę!");
                System.exit(0);
            } else {
                System.out.println("Wprowadziłeś błędną zmienną, zdecyduj jeszcze raz czy chcesz grać dalej");
                move = ifPlays.next().charAt(0);
            }



    }
}
