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

    MockCommandLine mock;

    @Before
    public void setUp(){
        mock = new MockCommandLine();
    }
    @Test
    public void shouldReturnOptionListBook(){
        assertEquals(12, BibliotecaApp.menu(new MockCommandLine()));
    }

    @Test
    public void shouldPrintBookListWhenUserSelectOptionNumberOne() {
        List<String> expectedMessages = Arrays.asList(
                "- Title: Livro1\tAuthor: Autor1\tPublication Year: 2021",
                "- Title: Livro2\tAuthor: Autor2\tPublication Year: 2019");

        BibliotecaApp.option(1, new MockLibrary(), mock);

        assertEquals(expectedMessages, mock.messageList);
    }

    static class MockLibrary implements ILibrary {
        @Override
        public List<Book> bookList() {
            return Arrays.asList(new Book("Livro1","Autor1", 2021),
                    new Book("Livro2","Autor2", 2019));
        }
    }

    static class MockCommandLine implements ICommandLine {
        public List<String> messageList = new ArrayList<>();
        public int scanValue = 12;
        @Override
        public void println(String message) {
            messageList.add(message);
        }

        @Override
        public int scanner() {
            return scanValue;
        }
    }

    @Test
    public void shouldShowMessageWhenUserChooseInvalidOption(){
        mock.scanValue = 0;
        BibliotecaApp.option(2, new MockLibrary(), mock);
        assertEquals("Please select a valid option!",mock.messageList.get(0));
    }
}


