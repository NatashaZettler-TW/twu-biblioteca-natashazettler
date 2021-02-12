package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void shouldReturnBookInformationWhenCallToStringMethod() {
        Book book = new Book("Livro1","Autor1");
        assertEquals("name: Livro1\nauthor: Autor1", book.toString());
    }

    @Test
    public void shouldCompareBooksWhenCallEqualsMethod(){
        Book book = new Book("Livro1","Autor1");
        Book otherBook = new Book("Livro1","Autor1");
        assertTrue(book.equals(otherBook));
    }

    @Test
    public void shouldReturnFalseWhenCompareTitleBooks(){
        Book book = new Book("Livro2","Autor1");
        Book otherBook = new Book("Livro1","Autor1");
        assertFalse(book.equals(otherBook));
    }

    @Test
    public void shouldReturnFalseWhenCompareAuthorBooks(){
        Book book = new Book("Livro1","Autor2");
        Book otherBook = new Book("Livro1","Autor1");
        assertFalse(book.equals(otherBook));
    }
}
