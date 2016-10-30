package com.aviacompany.project.model.aircraft.passengerAircraft;

import com.aviacompany.project.model.aircraft.Aircraft;
import com.aviacompany.project.model.passenger.Place;

import java.util.ArrayList;

public class Airbus380 extends PassangerAircraft implements Aircraft {
    String route;

    public Airbus380() {
        this.countPlace = 50;                    // кол-во мест для груза
        this.maxDistance = 15000;                  // в километрах
        this.fuelConsumptionVolume = 250000;      // макс. масса топлива в килограммах
        this.maxMassBaggage = 50000;             // грузоподъемность в килограммах
        this.allMassBaggage = 0;
        this.countBusyPlace = 0;
    }

    @Override
    public void loadPlace(Place place) {
        if (listPlace==null) listPlace = new ArrayList<Place>();
        if ((countBusyPlace <= countPlace) &&
                (place.getBaggage().getMas() <= maxMassBaggage / countPlace)
                && (place.getPassanger().isHaveTicket()==true)) {                                                 //если есть свободные
            place.setNumber(countBusyPlace++);                                                                     //места и масса груза
            this.listPlace.add(place);
            this.allMassBaggage+=place.getBaggage().getMas();                                                      //не превышает
        }                                                                                                         // допустимые значения
        /*else System.out.println("Пассажир не может пройти билетный контроль");      */                                // загружаем aircraft
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
