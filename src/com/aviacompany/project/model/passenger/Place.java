package com.aviacompany.project.model.passenger;

public class Place {
    private Baggage baggage;
    private int number;
    private Passanger passanger;

    // конструктор для пассажирского самолета
    public Place(Baggage baggage, Passanger passanger) {
        this.baggage = baggage;
        this.passanger = passanger;
    }

    // конструктор для грузового самолета
    public Place(Baggage baggage) {
        this.baggage = baggage;
    }

    public Baggage getBaggage() {
        return baggage;
    }

    public Passanger getPassanger() {
        return passanger;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
