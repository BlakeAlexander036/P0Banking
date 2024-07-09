package com.revature.manager;

import com.revature.controllers.BankAccountController;
import com.revature.controllers.UserController;
import com.revature.views.TerminalView;

public class ApplicationManager {
    private UserController userController;
    private BankAccountController bankAccountController;
    private TerminalView terminalView;

    public ApplicationManager() {
        // Initialize repositories, services, controllers, and views
    }

    // Method to run the application
    public void run() {
        // Main loop for the application
        // Welcome... and TerminalView popup

        // login / register / quit

        // once logged in... Bank account CRUD, User CRUD, Quit
    }
}
