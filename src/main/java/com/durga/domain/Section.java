package com.durga.domain;

public class Section {

    private String sectionName;
    private int seatCount;
    private int availableSeats;


    public Section(final String sectionName, final int seatCount, final int availableSeats) {
        this.sectionName = sectionName;
        this.seatCount = seatCount;
        this.availableSeats = availableSeats;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public boolean seatsUnavailable(){
        return availableSeats ==0 ? true : false;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionName='" + sectionName + '\'' +
                ", seatCount=" + seatCount +
                ", availableSeats=" + availableSeats +
                '}';
    }

    public boolean isExactMatch(Section currentSection, int ticketCount) {
        return currentSection.getAvailableSeats() == ticketCount ? true : false;
    }
}