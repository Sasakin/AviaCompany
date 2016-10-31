package com.aviacompany.project;


import com.aviacompany.project.controller.Controller;
import com.aviacompany.project.model.aviacompany.Aviacompany;

import java.io.IOException;
import com.aviacompany.project.read.Read;

public class Main {
    public static void main(String args[]) {
        Controller controller = new Controller();
        controller.startProgramm();
        //System.out.println("Список самолетов: "+ controller.getAviacompany().getAircrafts());
    }
}
