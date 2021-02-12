package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryController implements ILibrary{
    List<Book> bookList;

    public LibraryController(){
        this.bookList = Arrays.asList(new Book("Livro1","Autor1", 2021),
                new Book("Livro2","Autor2", 2019));
    }

    @Override
    public List<Book> bookList() {
        return this.bookList.stream().filter(book -> !book.getBorrowed()).collect(Collectors.toList());
    }

    @Override
    public Boolean borrow(String title) {
        for(Book book : this.bookList){
            if(bookTitleIsEquals(title, book) && !book.getBorrowed()){
                book.setBorrowed(true);
                return true;
            }
        }
        
        return false;
    }

    private boolean bookTitleIsEquals(String title, Book book) {
        return book.getTitle().toLowerCase().equals(title.toLowerCase());
    }
}
