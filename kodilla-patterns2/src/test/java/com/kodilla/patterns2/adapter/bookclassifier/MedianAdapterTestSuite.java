package com.kodilla.patterns2.adapter.bookclassifier;


import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.MedianAdapter;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

        @Test
        void publicationYearMedianTest() {
            // given
            MedianAdapter adapter = new MedianAdapter();
            Set<Book> bookSet = new HashSet<>();
            bookSet.add(new Book("author1", "title1", 1993, "signature1"));
            bookSet.add(new Book("author2", "title2", 2000, "signature2"));
            bookSet.add(new Book("author3", "title3", 1975, "signature3"));
            bookSet.add(new Book("author4", "title4", 2022, "signature4"));
            bookSet.add(new Book("author5", "title5", 2007, "signature5"));
            bookSet.add(new Book("author6", "title6", 2009, "signature6"));
            bookSet.add(new Book("author7", "title7", 2014, "signature7"));
            // when
            int median = adapter.publicationYearMedian(bookSet);
            System.out.println("\n" + median + "\n");
            // then
            assertEquals(2007, median);
        }

}
