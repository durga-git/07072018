package com.durga.service;

import com.durga.domain.Ticket;

public interface BookingService {

    /**
     * This method employs a business logic that involves traversing a service structure with a java String input and compute
     * the seat alotment for the patron in the input String.
     *
     * @param request A String representation of the patron name followed by a space character followed by an int value representing the number of seats requested.
     * @param theaterService The Theater structure representing layout of the rows -> sections -> seats
     *
     * @return void
     */
    public Ticket bookTickets(final String request, final TheaterService theaterService);

    /**
     * This method returns true by applying logic that is suitable for the input required format.
     * @param inputString
     *
     * @return returns @True if the input is in the right format
     */
    public boolean rightInputFormat(String inputString);
}
