package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Library extends LibraryPrototype<Library>{

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library shallowCopy() throws CloneNotSupportedException{
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException{
        Library deepClonedLibrary = super.clone();
        deepClonedLibrary.books = new HashSet<>();
        for(Book book : books){
            deepClonedLibrary.books.add(book);
        }
        return  deepClonedLibrary;
    }

    @Override
    public String toString(){
        String libraryBooks = "List [" + name + "]";
        for (Book book : books){
            libraryBooks = libraryBooks + "\n" + book.toString();
        }
        return libraryBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) && Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books);
    }
}