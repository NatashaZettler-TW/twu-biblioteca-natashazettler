package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.ILibrary;
import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    MockCommandLine mockCommandLine;
    MockLibrary mockLibrary;

    @Before
    public void setUp(){
        mockCommandLine = new MockCommandLine();
        mockLibrary = new MockLibrary();
    }
    @Test
    public void shouldReturnOptionListBook(){
        assertEquals(12, BibliotecaApp.menu(mockCommandLine));
    }

    @Test
    public void shouldPrintBookListWhenUserSelectOptionNumberOne() {
        List<String> expectedMessages = Arrays.asList(
                "- Title: Livro1\tAuthor: Autor1\tPublication Year: 2021",
                "- Title: Livro2\tAuthor: Autor2\tPublication Year: 2019");

        mockCommandLine.scanValue = 0;
        BibliotecaApp.option(1, mockLibrary, mockCommandLine);
        assertEquals(expectedMessages.get(0), mockCommandLine.messageList.get(0));
        assertEquals(expectedMessages.get(1), mockCommandLine.messageList.get(1));
    }

    static class MockLibrary implements ILibrary {
        public boolean isBorrow = false;
        public boolean returnBook = false;

        @Override
        public List<Book> bookList() {
           return Arrays.asList(new Book("Livro1","Autor1", 2021),
                   new Book("Livro2","Autor2", 2019));
        }

        @Override
        public boolean borrow(String title) {
            return isBorrow;
        }

        @Override
        public boolean returnBook(String title) {
            return returnBook;
        }
    }

    static class MockCommandLine implements ICommandLine {
        public List<String> messageList = new ArrayList<>();
        public int scanValue = 12;
        public String scanValueText = "livro1";
        @Override
        public void println(String message) {
            messageList.add(message);
        }

        @Override
        public int scanner() {
            return scanValue;
        }

        @Override
        public String scannerText() {
            return scanValueText;
        }
    }

    @Test
    public void shouldShowMessageWhenUserChooseInvalidOption(){
        mockCommandLine.scanValue = 0;
        BibliotecaApp.option(10, mockLibrary, mockCommandLine);
        assertEquals("Please select a valid option!",mockCommandLine.messageList.get(0));
    }

    @Test
    public void shouldShowMessageWhenUserChooseQuitApplication(){
        BibliotecaApp.option(0, mockLibrary, mockCommandLine);
        assertEquals("Thank you for use the system. Come back soon.",mockCommandLine.messageList.get(0));
    }

    @Test
    public void shouldShowSuccessMessageWhenUserChooseReturnBook(){
        mockCommandLine.scanValue = 0;
        mockCommandLine.scanValueText = "livro1";
        mockLibrary.returnBook = true;
        BibliotecaApp.option(3, mockLibrary, mockCommandLine);
        assertEquals("Thank you for returning the book.",mockCommandLine.messageList.get(1));
    }

    @Test
    public void shouldShowMessageBookIsNotValidWhenUserChooseReturnBookThatAlreadyIsInTheLibrary(){
        mockCommandLine.scanValue = 0;
        mockCommandLine.scanValueText = "livro2";
        BibliotecaApp.option(3, mockLibrary, mockCommandLine);
        assertEquals("That is not a valid book to return.",mockCommandLine.messageList.get(1));
    }

    @Test
    public void shouldShowSuccessMessageWhenUserChooseBorrowBook(){
        mockCommandLine.scanValue = 0;
        mockCommandLine.scanValueText = "livro1";
        mockLibrary.isBorrow = true;
        BibliotecaApp.option(2, mockLibrary, mockCommandLine);
        assertEquals("Thank you! Enjoy the book.", mockCommandLine.messageList.get(1));
    }

    @Test
    public void shouldShowMessageBookIsNotValidWhenUserChooseReturnBookThatAlreadyIsTheLibrary(){
        mockCommandLine.scanValue = 0;
        mockCommandLine.scanValueText = "livro2";
        BibliotecaApp.option(2, mockLibrary, mockCommandLine);
        assertEquals("Sorry, that book is not available.",mockCommandLine.messageList.get(1));
    }
}


