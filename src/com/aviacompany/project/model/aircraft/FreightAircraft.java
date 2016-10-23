package com.aviacompany.project.model.aircraft;

import com.aviacompany.project.model.passenger.Baggage;
import com.aviacompany.project.model.passenger.Place;

import java.util.ArrayList;
import java.util.List;

public abstract class FreightAircraft implements Aircraft {
    protected int countPlace;
    protected int countBusyPlace;
    protected double allMassBaggege;
    protected int maxDistance = 0;
    protected ArrayList<Place> listPlace;

    public double getAllMassBaggege() {
        return allMassBaggege;
    }

    public void setAllMassBaggege(double allMassBaggege) {
        this.allMassBaggege = allMassBaggege;
    }

    public int getCountBusyPlace() {
        return countBusyPlace;
    }

    public void setCountBusyPlace(int countBusyPlace) {
        this.countBusyPlace = countBusyPlace;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public int getCountPlace() {
        return countPlace;
    }

    public ArrayList<Place> getListPlace() {
        return listPlace;
    }

    @Override
    public String toString() {
        return "\n\n PassengerWagon | " +
                "MaxDistance = " + maxDistance +
                " | countPlace = " + countPlace +
                " | countBusyPlace = " + countBusyPlace;
    }


    @Override
    public int compareTo(FreightAircraft ob) {
        if(ob == null)
            return -1;
        if(ob.getMaxDistance() == 0)
            return -1;

        return this.getMaxDistance() - ob.getMaxDistance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerWagon that = (PassengerWagon) o;

        if (countPlace != that.countPlace) return false;
        if (typeWagon != null ? !typeWagon.equals(that.typeWagon) : that.typeWagon != null) return false;
        return listPlace != null ? listPlace.equals(that.listPlace) : that.listPlace == null;

    }
}
