package com.twu.biblioteca;

import com.twu.biblioteca.controller.LibraryController;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        LibraryController libraryController = new LibraryController();
        System.out.println(libraryController.bookList().toString());
    }
}