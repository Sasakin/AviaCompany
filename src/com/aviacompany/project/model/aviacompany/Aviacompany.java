package com.aviacompany.project.model.aviacompany;

import com.aviacompany.project.model.aircraft.Aircraft;
import com.aviacompany.project.model.aircraft.freightAircraft.An124;
import com.aviacompany.project.model.aircraft.freightAircraft.Tu136;
import com.aviacompany.project.model.aircraft.passengerAircraft.Airbus380;
import com.aviacompany.project.model.aircraft.passengerAircraft.Boeing747;
import com.aviacompany.project.model.passenger.Baggage;
import com.aviacompany.project.model.passenger.Passanger;
import com.aviacompany.project.model.passenger.Place;
import com.aviacompany.project.read.Read;
import com.aviacompany.project.read.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Aviacompany {
    private List<Aircraft> aircrafts = new ArrayList<>();

    private List<String> Routs;

    volatile Aircraft  aircraft;

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void fillSendGoods()  throws IOException {
        Read test = new Read();
        test.reader();
        int i=0;
        for (User newUser : test.getMass()) {    // создаем грузовые самолеты и задаем им путь
            newUser.chislo=i;
            if(i!=0){
                        aircraft = new An124();
                        aircraft.setRoute(newUser.key);
                        aircrafts.add(aircraft);
                        System.out.println(aircraft);
            }
            i++;
        }
        for(Aircraft a:aircrafts) {                                // загружаем самолет грузом
            while (a.getCountBusyPlace()<a.getCountPlace()) {
                Place place = new Place(new Baggage(Math.random() * a.getMaxMas()));
                a.loadPlace(place);
            }
        }
    }

    public void fillTreveling()  throws IOException {
        Read test = new Read();
        test.reader();
        int i=0;
        Random random = new Random();
        for (User newUser : test.getMass()) {     // создаем грузовые самолеты и задаем им путь
            newUser.chislo=i;
            if(i!=0){
                    aircraft = new Boeing747();
                    aircraft.setRoute(newUser.key);
                    aircrafts.add(aircraft);
            }
            i++;
        }
        for(Aircraft a:aircrafts) {                                // загружаем самолет грузом
            while (a.getCountBusyPlace()<a.getCountPlace()) {
                Place place = new Place(new Baggage(Math.random() * a.getMaxMas())
                , new Passanger(random.nextBoolean()));
                a.loadPlace(place);
            }
        }
    }

    Aircraft serchAircraftByFuel(int maxFuel, int minFuel) {
        for(Aircraft aircraft:aircrafts){
            if(aircraft.getFuel()<maxFuel && aircraft.getFuel()>minFuel)
                return aircraft;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
         for(Aircraft a:aircrafts) res.append(a.toString()+" route " + a.getRoute());
        return res.toString();
    }
}
