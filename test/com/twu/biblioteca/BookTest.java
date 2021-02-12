package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void shouldPrintWhenCallToStringMethod() {
        Book book = new Book("Livro1","Autor1");
        assertEquals("name: Livro1\nauthor: Autor1", book.toString());
    }
}
