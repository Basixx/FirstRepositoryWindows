package com.kodilla.patterns.prototype.library;

public class LibraryPrototype<B> implements Cloneable{

    @Override
    public B clone() throws CloneNotSupportedException{
        return (B)super.clone();
    }
}
