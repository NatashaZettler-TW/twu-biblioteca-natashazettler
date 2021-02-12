package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void shouldReturnBookInformationWhenCallToStringMethod() {
        Book book = new Book("Livro1","Autor1", 2021);
        assertEquals("Title: Livro1\tAuthor: Autor1\tPublication Year: 2021", book.toString());
    }

    @Test
    public void shouldCompareBooksWhenCallEqualsMethod(){
        Book book = new Book("Livro1","Autor1", 2021);
        Book otherBook = new Book("Livro1","Autor1", 2021);
        assertTrue(book.equals(otherBook));
    }

    @Test
    public void shouldReturnFalseWhenCompareTitleBooks(){
        Book book = new Book("Livro2","Autor1", 2021);
        Book otherBook = new Book("Livro1","Autor1", 2021);
        assertFalse(book.equals(otherBook));
    }

    @Test
    public void shouldReturnFalseWhenCompareAuthorBooks(){
        Book book = new Book("Livro1","Autor2", 2021);
        Book otherBook = new Book("Livro1","Autor1", 2021);
        assertFalse(book.equals(otherBook));
    }

    @Test
    public void shouldReturnFalseWhenComparePublicationYearBooks(){
        Book book = new Book("Livro1","Autor2", 2021);
        Book otherBook = new Book("Livro1","Autor1", 2020);
        assertFalse(book.equals(otherBook));
    }
}
