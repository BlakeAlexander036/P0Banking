package com.revature.views;

import java.util.Scanner;

public abstract class TerminalView {
    protected Scanner scanner;

    public TerminalView(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract void displayMenu();

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
