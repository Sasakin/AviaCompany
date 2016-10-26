package com.aviacompany.project.model.aircraft;


import com.aviacompany.project.model.passenger.Place;

public interface Aircraft {

    public String getRoute();

    public void setRoute(String route);   // задать маршрут

    public void loadPlace(Place place);  // загрузить самолет грузом или пасажирами
                                         // предполагается что груз или пасажир прикреплен к месту, а не наоборот
    public int getFuel();

    public double getMaxMas();

    public int getCountPlace();

    public int getCountBusyPlace();

    public  String getTypeAircraft();

}
