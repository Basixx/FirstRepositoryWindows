package com.kodilla.spring.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig {
//XDDDDD
    @Bean
    public Library library() {
        return new Library(libraryDbController());
    }

    @Bean
    public LibraryDbController libraryDbController() {
        return new LibraryDbController();
    }
}