package com.durga.domain;

public class Ticket {
    String message;
    String patronName;

    public Ticket(String patronName) {
        this.patronName = patronName;
    }

    public Ticket(String message, String patronName) {
        this.message = message;
        this.patronName = patronName;
    }

    public Ticket() {
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.getPatronName()+ " " +this.getMessage();
    }
}
