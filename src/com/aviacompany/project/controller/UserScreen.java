package com.aviacompany.project.controller;

import java.util.Scanner;

public class UserScreen {

    private String pathToFileRoutesPassengerTrains = "resources\\passenger\\Route.txt";
    private String pathToFileCreateTrainsOnTrain = "resources\\passenger\\CreateTrains.txt";
    private String pathToFileListActionsOnTrain = "resources\\passenger\\Actions.txt";
    private String messageErrorChoice = "\nТакого пункта нет в списке.\nВыбирите пожалуйста номер пункта из списка\n";
    private InterfaceScreen listTrain;
    private InterfaceScreen listCreateTrain;
    private InterfaceScreen listAction;
    Controller controller;

    public UserScreen() {
        controller = new Controller();

        listTrain = new InterfaceScreen(pathToFileRoutesPassengerTrains, TypeInterfaceScreen.LIST_TRAIN, controller);
        listCreateTrain = new InterfaceScreen(pathToFileCreateTrainsOnTrain, TypeInterfaceScreen.LIST_CREATE_TRAIN, controller);
        listAction = new InterfaceScreen(pathToFileListActionsOnTrain, TypeInterfaceScreen.LIST_ACTION, controller);

        listTrain.setNext(listCreateTrain);
        listCreateTrain.setBack(listTrain);
        listCreateTrain.setNext(listAction);
        listAction.setBack(listCreateTrain);
    }


    public void userInterface(Scanner scanner) {
        createTrains(scanner, listTrain);
    }

    private void createTrains(Scanner scanner, InterfaceScreen interfaceScreen) {

        int countHelp = 0;
        boolean endWork = false;

        while (!endWork) {
            if (countHelp == 0) {
                interfaceScreen.showInterfaceScreen();
            }
            if (scanner.hasNextInt()) {
                int inputNumber = scanner.nextInt();
                if ((inputNumber > 0) && (inputNumber <= interfaceScreen.getMapListScreenView().size())) {
                    interfaceScreen = interfaceScreen.performSelectedAction(inputNumber);
                    endWork = interfaceScreen.isEndWork();
                } else {
                    controller.showString(messageErrorChoice);
                }
            } else {
                countHelp++;
                scanner.nextLine();
                if (countHelp == 1) {
                    controller.showString(messageErrorChoice);
                } else {
                    countHelp = 0;
                }
            }
        }
    }
}