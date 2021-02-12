package com.twu.biblioteca.model;

public class Book {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString(){
        return "name: "+ this.name + "\nauthor: "+this.author;
    }
}
