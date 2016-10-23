package com.aviacompany.project.model.flight;

/**
 * Created by Student on 22.10.2016.
 */
public class Flight {
    String flightNumber[];

    public Flight() {
        for(String flight:flightNumber){
            System.out.println(this);
        }
    }

    public void journey(String sity1, String sity2) {
        System.out.println("Aircraft fly from "+sity1+" to "+sity2+".");
    }

}
