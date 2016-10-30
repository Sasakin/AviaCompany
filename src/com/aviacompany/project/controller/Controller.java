package com.aviacompany.project.controller;


import java.util.Scanner;

public class Controller {

    private Scanner scanner = new Scanner(System.in);
    private UserScreen user;

    public void startProgramm(){
        try{
            user = new UserScreen();
            user.userInterface(scanner);
        }finally {
            scanner.close();
        }

    }
}
