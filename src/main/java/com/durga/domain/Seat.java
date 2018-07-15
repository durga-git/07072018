package com.durga.domain;

public class Seat {
    private boolean alloted;

    public Seat(boolean alloted) {
        this.alloted = alloted;
    }

    public boolean isAlloted() {
        return alloted;
    }

    public void setAlloted(boolean alloted) {
        this.alloted = alloted;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "alloted=" + alloted +
                '}';
    }
}
