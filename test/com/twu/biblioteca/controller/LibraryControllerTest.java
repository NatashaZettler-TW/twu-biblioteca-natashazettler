package com.twu.biblioteca.controller;


import com.twu.biblioteca.model.Book;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryControllerTest {

    @Test
    public void shouldReturnBookList(){
        List<Book> expectedBookList = Arrays.asList(new Book("Livro1","Autor1"), new Book("Livro2","Autor2"));
        LibraryController libraryController = new LibraryController();
        assertEquals(expectedBookList, libraryController.bookList());
    }

}
