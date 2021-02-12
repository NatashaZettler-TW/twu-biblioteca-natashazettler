package com.twu.biblioteca.view;

import java.util.Scanner;

public class SystemCommandLine implements ICommandLine{
    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public int scanner() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
