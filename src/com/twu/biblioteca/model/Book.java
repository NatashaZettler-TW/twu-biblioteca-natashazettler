package com.twu.biblioteca.model;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private Boolean borrowed;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.borrowed = false;
    }

    @Override
    public String toString(){
        return "Title: "+ this.title + "\tAuthor: "+this.author + "\tPublication Year: "+this.publicationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    public Boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getTitle() {
        return title;
    }
}
