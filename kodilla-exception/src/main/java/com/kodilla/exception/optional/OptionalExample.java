package com.kodilla.exception.optional;
import com.kodilla.exception.nullpointer.User;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        User user = new User("John");
        User userNull = null;
        Optional<User> optionalUser = Optional.ofNullable(user);
        Optional<User> optionalNullUser = Optional.ofNullable(userNull);
        System.out.println("Start");

        //orElse for a correct user
        String username = optionalUser.orElse(new User("...")).getName();
        System.out.println(username);

        //orElse for a null user
        String usernameNull = optionalNullUser.orElse(new User("...")).getName();
        System.out.println(usernameNull);

        //ifPresent for a correct user
        optionalUser.ifPresent(u -> System.out.println(u.getName()));

        //ifPresent for a null user
        optionalNullUser.ifPresent(u -> System.out.println(u.getName()));

        System.out.println("Finish");
    }
}
