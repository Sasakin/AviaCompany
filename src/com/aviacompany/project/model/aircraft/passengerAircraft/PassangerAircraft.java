package com.aviacompany.project.model.aircraft.passengerAircraft;

import com.aviacompany.project.model.passenger.Place;

import java.util.ArrayList;

public abstract class PassangerAircraft  implements Comparable<PassangerAircraft> {
    protected int countPlace;
    protected int countBusyPlace;
    protected double maxMassBaggage;
    protected double allMassBaggage;
    protected Integer maxDistance;
    protected ArrayList<Place> listPlace;
    protected int fuelConsumptionVolume;                        // объем потребления топлива
    protected static final String TYPE_AIRCRAFT = "Passanger";   // тип - пассажирский

    public int getFuelConsumptionVolume() {
        return fuelConsumptionVolume;
    }

    public double getMaxMassBaggage() {
        return maxMassBaggage;
    }

    public double getAllMassBaggage() {
        return allMassBaggage;
    }

    public void setAllMassBaggege(double allMassBaggage) {
        this.allMassBaggage = allMassBaggage;
    }

    public int getCountBusyPlace() {
        return countBusyPlace;
    }

    abstract String getRoute();

    public void setCountBusyPlace(int countBusyPlace) {
        if(countBusyPlace <= countPlace)
            this.countBusyPlace = countBusyPlace;
        else System.out.println("countBusyPlace should not exceed then countPlace");
    }


    public Integer getMaxDistance() {
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
        return "\n\n PassangerAircraft | " +
                " | route = " + this.getRoute()+
                " typeAircraft = " + TYPE_AIRCRAFT +
                " | MaxDistance = " + maxDistance +
                " | maxMassBaggage = " + maxMassBaggage +
                " | allMassBaggage = " + allMassBaggage +
                " | fuelConsumptionVolume = " + fuelConsumptionVolume +
                " | countPlace = " + countPlace +
                " | countBusyPlace = " + countBusyPlace;
    }


    @Override
    public int compareTo(PassangerAircraft ob) {
        if(ob == null)
            return -1;
        if(ob.getMaxDistance() == null)
            return -1;

        return (int) this.getMaxDistance() -  ob.getMaxDistance();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassangerAircraft that = (PassangerAircraft) o;

        if (countPlace != that.countPlace) return false;
        if (countBusyPlace != that.countBusyPlace) return false;
        if (Double.compare(that.allMassBaggage, allMassBaggage) != 0) return false;
        if (maxDistance != that.maxDistance) return false;
        if (fuelConsumptionVolume != that.fuelConsumptionVolume) return false;
        return listPlace != null ? listPlace.equals(that.listPlace) : that.listPlace == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = countPlace;
        result = 31 * result + countBusyPlace;
        temp = Double.doubleToLongBits(allMassBaggage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + maxDistance;
        result = 31 * result + (listPlace != null ? listPlace.hashCode() : 0);
        result = 31 * result + fuelConsumptionVolume;
        return result;
    }
}
