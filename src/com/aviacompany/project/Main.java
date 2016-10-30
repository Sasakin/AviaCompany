package com.aviacompany.project;


import com.aviacompany.project.model.aviacompany.Aviacompany;

import java.io.IOException;
import com.aviacompany.project.read.Read;

public class Main {
    public static void main(String args[]) {
        Aviacompany aviacompany = new Aviacompany();
        try {
            aviacompany.fillTreveling();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Список самолетов: "+ aviacompany.getAircrafts());
    }
}
