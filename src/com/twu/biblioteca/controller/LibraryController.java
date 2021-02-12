package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import java.util.Arrays;
import java.util.List;

public class LibraryController {

    public List<Book> bookList() {
        return Arrays.asList(new Book("Livro1","Autor1", 2021), new Book("Livro2","Autor2", 2019));
    }
}
