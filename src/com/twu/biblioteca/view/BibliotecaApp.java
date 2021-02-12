package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.ILibrary;
import com.twu.biblioteca.controller.LibraryController;
import com.twu.biblioteca.model.Book;

public class BibliotecaApp {

    public static int menu(ICommandLine system){
        while(true) {
            try {
                system.println("\nChoose one option");
                system.println("\t1 - List of books");
                return system.scanner();
            } catch (Exception exception) {
                system.println("Ops. Something went wrong. Try again.");
            }
        }
    }

    public static void option(int menu, ILibrary libraryController, ICommandLine system){
        switch (menu) {
            case 1:
                for (Book book : libraryController.bookList()) {
                    system.println("- " + book.toString());
                }
                break;
            case 0:
                system.println("Thank you for use the system. Come back soon.");
                return;
            default:
                system.println("Please select a valid option!");
                break;
        }
        option(menu(system), libraryController, system);
    }

    public static void main(String[] args) {
        SystemCommandLine system = new SystemCommandLine();
        welcomeMessage(system);
        option(menu(system), new LibraryController(), system);
    }

    public static void welcomeMessage(ICommandLine system){
        system.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}