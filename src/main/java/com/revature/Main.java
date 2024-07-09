package com.revature;

import com.revature.manager.ApplicationManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            ApplicationManager appManager = new ApplicationManager(scanner);
            appManager.run();
        }
    }
}
