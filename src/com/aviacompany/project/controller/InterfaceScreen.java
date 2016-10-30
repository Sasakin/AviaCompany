package com.aviacompany.project.controller;

import ua.com.westwind.project.model.trainfactory.PassengerTrain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InterfaceScreen {

    private int countItemInList;
    private String headScreen;
    private Map<Integer, String> mapListScreenView = new HashMap<>();
    private TypeInterfaceScreen typeScreen;
    private InterfaceScreen back;
    private InterfaceScreen next;
    private Controller controller;
    private boolean endWork;
    String errProcessingInputData = "Извените, произошла ошибка обработки введённых данных";
    String errInput = "Введены не коректные данные";

    public InterfaceScreen(String path, TypeInterfaceScreen typeScreen, Controller controller) {
        this.typeScreen = typeScreen;
        readFromFileList(path);
        this.controller = controller;
    }

    public InterfaceScreen performSelectedAction(int input) {
        if (typeScreen == TypeInterfaceScreen.LIST_TRAIN) {
            return performSelectedActionLTrain(input);
        } else if (typeScreen == TypeInterfaceScreen.LIST_CREATE_TRAIN) {
            return performSelectedActionLCTrain(input);
        } else if (typeScreen == TypeInterfaceScreen.LIST_ACTION) {
            return performSelectedActionLAction(input);
        } else return this;
    }


    private InterfaceScreen performSelectedActionLTrain(int input) {
        if (input == mapListScreenView.size()) {
            endWork = true;
            return this;
        } else if ((input > 0) && (input <= mapListScreenView.size() - 2)) {
            PassengerTrain train = null;
            try {
                String route = mapListScreenView.get(input);
                train = controller.createPassengerTrainFromBase(route);
                String help = next.getMapListScreenView().put(next.countItemInList, route);
                next.getMapListScreenView().put(++next.countItemInList, help);
                controller.getMapCreatePassengerTrains().put(route, train);
                System.out.println("\nПоезд создан");
                train.showHeadTrain();
            } catch (Exception e) {
                e.printStackTrace();
                controller.showString(errProcessingInputData);
            }
            return this;
        } else if (input <= mapListScreenView.size() - 1) {
            return next;
        } else return this;

    }

    private InterfaceScreen performSelectedActionLCTrain(int input) {
        if (input == mapListScreenView.size()) {
            return back;
        } else if ((input > 0) && (input <= mapListScreenView.size())) {
            try {
                String route = mapListScreenView.get(input);
                controller.setTrain(controller.getMapCreatePassengerTrains().get(route));
            } catch (Exception e) {
                e.printStackTrace();
                controller.showString(errProcessingInputData);
            }
            return next;
        } else return this;

    }

    private InterfaceScreen performSelectedActionLAction(int input) {
        String messageInputValue = "Введите минимальное и максимальное колличество пассажиров в вагоне (от 0 до 135)";
        if (input == mapListScreenView.size()) {
            return back;
        } else if ((input > 0) && (input <= mapListScreenView.size())) {
            try {
                switch (input) {
                    case 1:
                        controller.getInPassengerTrainCountPassenger(controller.getTrain());
                        controller.getInPassengerTrainAllMassBaggege(controller.getTrain());
                        break;

                    case 2:
                        controller.sortPassengerTrainOfComfort(controller.getTrain());
                        break;

                    case 3:
                        controller.printLine();
                        controller.showString(messageInputValue);
                        controller.printLine();

                        int one = inputMinAndMax(controller.getScanner());
                        int two = inputMinAndMax(controller.getScanner());
                        if (one <= two) {
                            controller.searchWagonByCountPassengers(controller.getTrain(), one, two);
                        } else {
                            controller.searchWagonByCountPassengers(controller.getTrain(), two, one);
                        }

                        break;

                    case 4:
                        controller.showPassengerTrain(controller.getTrain());
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
                controller.showString(errProcessingInputData);
            }
            return this;
        } else return this;
    }

    private int inputMinAndMax(Scanner sc) {
        int countHelp = 0;
        int minCountPassengerInWagon = 0;
        int maxCountPassengerInWagon = 135;
        boolean endWork = false;
        int number = 0;
        int help = 0;
        while (!endWork) {
            if (sc.hasNextInt() &&
                    ((help = sc.nextInt()) >= minCountPassengerInWagon) &&
                    (help <= maxCountPassengerInWagon)) {
                number = help;
                endWork = true;
            } else {
                countHelp++;
                sc.nextLine();
                if (countHelp == 1) {
                    controller.showString(errInput);
                } else {
                    countHelp = 0;
                }
            }
        }
        return number;
    }


    public void showInterfaceScreen() {
        controller.showInterfaceScreen(headScreen, mapListScreenView);
    }


    private void readFromFileList(String path) {
        File file = new File(path);
        countItemInList = 0;
        try (BufferedReader rd = new BufferedReader(new FileReader(file))) {
            String strHelp;
            while ((strHelp = rd.readLine()) != null) {
                if (countItemInList == 0) {
                    headScreen = strHelp;
                    countItemInList++;
                } else {
                    mapListScreenView.put(countItemInList, strHelp);
                    countItemInList++;
                }
            }
            countItemInList--;
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла " + path);
        }
    }

    public boolean isEndWork() {
        return endWork;
    }

    public Map<Integer, String> getMapListScreenView() {
        return mapListScreenView;
    }

    public void setBack(InterfaceScreen back) {
        this.back = back;
    }


    public void setNext(InterfaceScreen next) {
        this.next = next;
    }
}
