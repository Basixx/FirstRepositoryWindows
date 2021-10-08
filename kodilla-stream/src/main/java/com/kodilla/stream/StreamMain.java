package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.person.People;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        People.getList().forEach(System.out::println);
        System.out.println("------------------------");

        People.getList().stream().map(name -> name.toUpperCase(Locale.ROOT)).forEach(System.out::println);
        System.out.println("------------------------");

        People.getList().stream().map(String::toUpperCase).forEach(name -> System.out.println(name));
        System.out.println("------------------------");

        People.getList().stream().filter(name -> name.length() > 11).forEach(System.out::println);
        System.out.println("------------------------");

        People.getList().stream()
                .map(String::toUpperCase)
                .filter(name -> name.length() > 11)
                .map(name -> name.substring(0, name.indexOf(' ') + 2) + ".")
                .filter(name -> name.substring(0, 1).equals("M"))
                .forEach(System.out::println);

        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getTheBookList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

        BookDirectory theBookDirectory1 = new BookDirectory();
        Map<String, Book> theResultMapOfBooks = theBookDirectory1.getTheBookList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        BookDirectory theBookDirectory2 = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory2.getTheBookList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString).collect(Collectors.joining(",\n", "<<", ">>"));
        System.out.println(theResultStringOfBooks);


        Forum forum = new Forum();
        Map<Integer, ForumUser> resultUserList = forum.getForumUsersList().stream()
                .filter(user -> user.getPostsCount() >= 1)
                .filter(user -> user.getGender() == 'M')
                .filter(user -> ChronoUnit.YEARS.between(user.getDateOfBirth(), LocalDate.now()) >= 20)
                .collect(Collectors.toMap(ForumUser::getUserID, user -> user));

        System.out.println("This forum has " + resultUserList.size() + " users");

        resultUserList.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);


    }
}