package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.model.Book;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        LibraryController libraryController = new LibraryController();
        System.out.println("List of books:");
        for(Book book : libraryController.bookList()){
            System.out.println("- "+book.toString());
        }

    }
}