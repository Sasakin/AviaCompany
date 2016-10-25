package com.aviacompany.project.model.passenger;


public class Passanger {
    private boolean haveTicket;

    public Passanger(boolean haveTicket) {
        this.haveTicket = haveTicket;
    }

    public boolean isHaveTicket() {
        return haveTicket;
    }

    public void setHaveTicket(boolean haveTicket) {
        this.haveTicket = haveTicket;
    }
}
