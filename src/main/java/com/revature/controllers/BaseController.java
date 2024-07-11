package com.revature.controllers;


import com.revature.services.ApplicationManagerService;

import java.util.Scanner;

public class BaseController {
    protected Scanner scanner;
    protected ApplicationManagerService applicationManagerService;

    public BaseController(Scanner scanner, ApplicationManagerService applicationManagerService) {
        this.scanner = scanner;
        this.applicationManagerService = applicationManagerService;
    }

}
