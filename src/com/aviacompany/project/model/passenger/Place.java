package com.aviacompany.project.model.passenger;

public class Place {
    private Baggage baggage;
    private int number;

    public Place(Baggage baggage) {
        this.baggage = baggage;
    }

    public Baggage getBaggage() {
        return baggage;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
