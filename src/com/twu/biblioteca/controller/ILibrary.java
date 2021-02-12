package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import java.util.List;

public interface ILibrary {

    List<Book> bookList();
    boolean borrow(String title);
    boolean returnBook(String title);
}
