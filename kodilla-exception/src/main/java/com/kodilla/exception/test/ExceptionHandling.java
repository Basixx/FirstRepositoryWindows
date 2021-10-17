package com.kodilla.exception.test;

public class ExceptionHandling extends Exception {
    public void checkNumbers(double x, double y) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(x,y));
        } catch (Exception a) {
            System.out.println("Error: " + a);
        } finally {
            System.out.println("goodbye");
        }
    }

}
