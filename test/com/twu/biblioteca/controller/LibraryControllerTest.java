package com.twu.biblioteca.controller;


import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryControllerTest {
    LibraryController libraryController;

    @Before
    public void setUp(){
        libraryController = new LibraryController();
    }

    @Test
    public void shouldReturnBookList(){
        List<Book> expectedBookList = Arrays.asList(new Book("Livro1","Autor1", 2021),
                new Book("Livro2","Autor2", 2019));
        assertEquals(expectedBookList, libraryController.bookList());
    }

    @Test
    public void shouldReturnNotBorrowedBookList(){
        libraryController.borrow("Livro2");
        List<Book> expectedBookList = Arrays.asList(new Book("Livro1","Autor1", 2021));
        assertEquals(expectedBookList, libraryController.bookList());
    }

    @Test
    public void shouldBorrowedABook(){
        assertTrue(libraryController.borrow("Livro1"));
    }

    @Test
    public void shouldNotBorrowedABook(){
        assertFalse(libraryController.borrow("Livro3"));
    }

    @Test
    public void shouldBorrowedABookWithTitleLowerCase(){
        assertTrue(libraryController.borrow("livro1"));
    }

    @Test
    public void shouldBorrowedABookOnlyOnce(){
        assertTrue(libraryController.borrow("Livro1"));
        assertFalse(libraryController.borrow("Livro1"));
    }
}
