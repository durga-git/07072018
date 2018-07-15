package com.durga.client;

import com.durga.domain.Row;
import com.durga.domain.Ticket;
import com.durga.service.Booking;
import com.durga.service.BookingService;
import com.durga.service.Theater;
import com.durga.service.TheaterService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    final static String CORRECT_FORMAT = "Please enter the inputs in correct format\n";
    final static String ENTER_TEXT = "Enter the patron name followed by space and number of tickets\n";
    final static String TOTAL_SEATS_TEXT = "Total Seats available :";
    final static String SORRY_TEXT = "SORRY, THEATER IS HOUSEFUL, COME BACK LATER\n";

    public static void main(String[] args) {
        BookingService bookingService = new Booking();
        TheaterService theaterService =  new Theater();

        // sample seat layout to construct the theater as given in sample input of the problem
        int[][] seatBluePrint = new int[5][];

        seatBluePrint[0] = new int[]{6,6};
        seatBluePrint[1] = new int[]{3,5,5,3};
        seatBluePrint[2] = new int[]{4,6,6,4};
        seatBluePrint[3] = new int[]{2,8,8,2};
        seatBluePrint[4] = new int[]{6,6};

        // we get a perfect theater structure with the following call to the theaterService.
        theaterService = theaterService.buildTheater(seatBluePrint);
        // print the rows and sections - not required but for illustration purpose.
        System.out.println("***********Theater***********\n");
        theaterService.getListOfRows().stream().map(Row::getRowName).forEach(u -> System.out.println(u));
        System.out.println("\n*************Row - Sections**********\n");
        theaterService.getListOfRows().stream().map(Row::getListOfSections).forEach(sections -> {
            System.out.println(sections);
        });
        System.out.println("*******************************\n");
        System.out.println(TOTAL_SEATS_TEXT+ theaterService.availableSeats(theaterService));

        List<Ticket> ticketList = new ArrayList<>();

        // Scanner to get the inputs from stdin.
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_TEXT);
        // read the inputs and allot the seats using bookingService and theaterService.
        while(scanner.hasNextLine()){
            if (theaterService.availableSeats(theaterService) == 0){
                System.out.println(SORRY_TEXT);
                break;
            }
            String line = scanner.nextLine();
            // You can exit the program by letting the user to give the * (star) command.
            if(line.equals("*"))
                break;
            // For each line read, call bookTickets method to seat allotment.
            if (bookingService.rightInputFormat(line) == true)
                ticketList.add(bookingService.bookTickets(line, theaterService));
            else System.out.println(CORRECT_FORMAT);
        }

        // Once you are done or enter the * command to exit, the tickets are printed to stdout.
        ticketList.stream().forEach(ticket -> System.out.println(ticket));
    }
}
