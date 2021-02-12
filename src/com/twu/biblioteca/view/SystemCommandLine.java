package com.twu.biblioteca.view;

import java.util.Scanner;

public class SystemCommandLine implements ICommandLine{
    private Scanner input;

    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public int scanner() {
        input = new Scanner(System.in);
        return input.nextInt();
    }

    @Override
    public String scannerText() {
        input = new Scanner(System.in);
        return input.next();
    }
}
