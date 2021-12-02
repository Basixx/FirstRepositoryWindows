package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;


public class LibraryTestSuite {
    @Test
    void testGetBooks()  {
        //given
        //creating library
        Library library = new Library("My Library");
        library.getBooks().add(new Book("The Hobbit", "J. R. R. Tolkien", LocalDate.of(1937, 9, 21)));
        library.getBooks().add(new Book("Harry Potter and the Philosopher’s Stone", "J.K. Rowling", LocalDate.of(1997, 6, 26)));
        library.getBooks().add(new Book("Czas pogardy", "Andrzej Sapkowski", LocalDate.of(1995, 1, 1)));
        library.getBooks().add(new Book("A Feast for Crows", "George R.R. Martin", LocalDate.of(2005, 10, 17)));

        //making a shallow clone of Library
        Library shallowClonedLibrary = null;
        try{
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("My Shallow Library");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //making a deep clone of Library
        Library deepClonedLibrary = null;
        try{
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("My DeepLibrary");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //when
        library.getBooks().add(new Book("The Lion, the Witch and the Wardrobe", "C. S. Lewis", LocalDate.of(1950, 10, 16)));
        //then

        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(5, library.getBooks().size());
        assertEquals(5, shallowClonedLibrary.getBooks().size());
        assertEquals(4, deepClonedLibrary.getBooks().size());
    }
}
