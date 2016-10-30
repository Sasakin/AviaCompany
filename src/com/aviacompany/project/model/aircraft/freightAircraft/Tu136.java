package com.aviacompany.project.model.aircraft.freightAircraft;

import com.aviacompany.project.model.aircraft.Aircraft;
import com.aviacompany.project.model.passenger.Place;

import java.util.ArrayList;

public class Tu136 extends FreightAircraft implements Aircraft {

    String route;

    public Tu136() {
        this.countPlace = 60;                 // кол-во мест для груза
        this.maxDistance = 2000;              // в километрах
        this.fuelConsumptionVolume = 4000; // макс. масса топлива в килограммах
        this.maxMassBaggage = 20000;        // грузоподъемность в килограммах
        this.allMassBaggage = 0;
        this.countBusyPlace = 0;
    }

    @Override
    public void loadPlace(Place place) {
        if (listPlace==null) listPlace = new ArrayList<Place>();
        if ((countBusyPlace <= countPlace) && (place.getBaggage().getMas() <= maxMassBaggage / countPlace)) {      //если есть свободные
            place.setNumber(countBusyPlace++);                                                                     //места и масса груза
            this.listPlace.add(place);
            this.allMassBaggage+=place.getBaggage().getMas();                                                      //не превышает
        }                                                                                                         // допустимые значения
       /* else System.out.println("Данный груз не соответствует требованиям");     */                                 // загружаем aircraft
    }
    @Override
    public String getRoute() {
        return route;
    }

    @Override
    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public int getFuel() {
        return this.fuelConsumptionVolume;
    }

    @Override
    public double getMaxMas() {
        return this.maxMassBaggage;
    }

    @Override
    public String getTypeAircraft() {
        return this.TYPE_AIRCRAFT;
    }

}
