package com.aviacompany.project.controller;


import com.aviacompany.project.model.aircraft.Aircraft;
import com.aviacompany.project.model.aircraft.passengerAircraft.PassangerAircraft;
import com.aviacompany.project.model.aviacompany.Aviacompany;
import com.aviacompany.project.view.View;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller extends View {
    private Aviacompany aviacompany = new Aviacompany();
    int userChoice = 0;


    private Scanner scanner = new Scanner(System.in);

    public void startProgramm(){
        while (userChoice!=4) {
            for (int i = 0; i < 100; i++)
                System.out.print("-");
            System.out.println(" ");
            System.out.println(" Создать пассажирские или грузовые рейсы?");
            for (int i = 0; i < 100; i++)
                System.out.print("-");
            System.out.println(" ");
            System.out.println("1. Пассажирский рейс");
            System.out.println("2. Отправить груз");
            System.out.println("3. Список самолетов");
            System.out.println("4. Выход");
            userChoice = scanner.nextInt();
            if(userChoice==2) {
                try {
                    aviacompany.fillSendGoods();
                    for (int i = 0; i < 100; i++)
                        System.out.print("-");
                    System.out.println(" ");
                    System.out.println(" Грузовой рейс отправлен, посмотреть список самолетов?");
                    for (int i = 0; i < 100; i++)
                        System.out.print("-");
                    System.out.println(" ");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(userChoice==1) {
                try {
                    aviacompany.fillTreveling();
                    for (int i = 0; i < 100; i++)
                        System.out.print("-");
                    System.out.println(" ");
                    System.out.println(" Пассажирский рейс отправлен, посмотреть список самолетов?");
                    for (int i = 0; i < 100; i++)
                        System.out.print("-");
                    System.out.println(" ");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(userChoice == 3) {
                System.out.println(aviacompany.getAircrafts());
            }
        }
    }

    public Aviacompany getAviacompany() {
        return aviacompany;
    }
}
