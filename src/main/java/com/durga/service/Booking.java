package com.durga.service;

import com.durga.domain.Row;
import com.durga.domain.Section;
import com.durga.domain.Ticket;

public class Booking implements BookingService {
    private static final String SORRY_MESSAGE = "Sorry, we can't handle your party.";
    private static final String SPLIT_MESSAGE = "Call to split party.";

    @Override
    public Ticket bookTickets(final String request, final TheaterService theaterService) {
        String[] requestArray = request.split(" ");
        String nameOfPatron = requestArray[0];
        int seatsRequested = Integer.parseInt(requestArray[1]);
        Ticket ticket = new Ticket(nameOfPatron);
        if (seatsRequested > theaterService.getTheaterCapacity() || seatsRequested > theaterService.availableSeats(theaterService)) {
            ticket.setMessage(SORRY_MESSAGE);
        }
        if(theaterService.splitNeeded(seatsRequested, theaterService) ){
            ticket.setMessage(SPLIT_MESSAGE);
        }

        outer:
        for (int i = 0; i < theaterService.getListOfRows().size(); i++) {
            Row currentRow = theaterService.getListOfRows().get(i);

            for (int j = 0; j < currentRow.getListOfSections().size(); j++) {
                Section currentSection = currentRow.getListOfSections().get(j);

                if (currentSection.seatsUnavailable())
                    continue;
                if (currentSection.isExactMatch(currentSection, seatsRequested)) {
                    // Allot the seats and break the outer for loop. We are done with this request.
                    currentSection.setAvailableSeats(0);
                    // Create a ticket response
                    ticket.setMessage(currentRow.getRowName() + " " + currentSection.getSectionName());
                    break outer;
                }
                if (currentSection.getAvailableSeats() >= seatsRequested) {
                    //allot the seats
                    currentSection.setAvailableSeats(currentSection.getAvailableSeats() - seatsRequested);
                    // Create a ticket response
                    ticket.setMessage(currentRow.getRowName() + " " + currentSection.getSectionName());
                    break outer;
                }
            }
        }

        System.out.println("Available seat count :"+ theaterService.availableSeats(theaterService));

        return ticket;
    }


    @Override
    public  boolean rightInputFormat(String s){
        if(s.split(" ").length !=2)
            return false;
        String[] input = s.split(" ");
        // disgard zero and nagative numbers
        if(input[1].chars().allMatch( Character::isDigit )  && Integer.parseInt(input[1]) > 0)
            return true;
        return false;
    }
}
