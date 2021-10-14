package com.kodilla.exception.test;

public class NumberChecker {
    public void checkNumbers(double x, double y) throws ExceptionHandling {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(x,y));
        } catch (ExceptionHandling a) {
            System.out.println("Error: " + a);
            throw new ExceptionHandling();
        } finally {
            System.out.println("all good");
        }
    }
}
