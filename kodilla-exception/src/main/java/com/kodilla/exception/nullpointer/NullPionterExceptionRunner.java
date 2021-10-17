package com.kodilla.exception.nullpointer;

import java.awt.*;

public class NullPionterExceptionRunner {
    public static void main(String[] args) {
        User user = null;
        MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessageTo(user, "Hello");
        } catch (MessageNotSentException e) {
            System.out.println("Message was not sent, but my program is still running very well");
        }

        System.out.println("Processing other logic");

        User user1 = new User("Janek");
        try {
            messageSender.sendMessageTo(user1, "Hello, "+user1.getName());
        } catch (MessageNotSentException e) {
            System.out.println("Message was not sent, but my program is still running very well");
        }

        try {
            messageSender.sendMessageTo(null, "Hello");
        } catch (MessageNotSentException e) {
            System.out.println("Message was not sent, but my program is still running very well");
        }
    }
}

