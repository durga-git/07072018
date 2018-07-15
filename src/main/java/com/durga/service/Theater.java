package com.durga.service;

import com.durga.domain.Row;
import com.durga.domain.Seat;
import com.durga.domain.Section;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Theater implements TheaterService {
    private String theaterName;
    private List<Row> listOfRows = new ArrayList<>();
    private int theaterCapacity;

    public Theater(final String theaterName, final List<Row> listOfRows, final int theaterCapacity) {
        this.theaterName = theaterName;
        this.listOfRows = listOfRows;
        this.theaterCapacity = theaterCapacity;
    }

    public Theater() {
    }

    @Override
    public List<Row> getListOfRows() {
        return listOfRows;
    }

    @Override
    public int getTheaterCapacity() {
        return theaterCapacity;
    }

    @Override
    public TheaterService buildTheater(int[][] seatBluePrint) {
        List<Row> listOfRows = new ArrayList<>(seatBluePrint.length);

        System.out.println("Seat Layout\n");
        printElements(seatBluePrint);
        System.out.println("\n");

        int totalSeatCount = 0;

        for (int index = 0; index < seatBluePrint.length; index++) {
            List<Section> currentListOfSections = new ArrayList<>();
            Row currentRow = new Row();
            currentRow.setRowName("ROW "+index);

            for (int j = 0; j < seatBluePrint[index].length; j++) {
                Section currentSection = new Section("SECTION "+j, seatBluePrint[index][j], populateSeats(seatBluePrint[index][j]));
                currentListOfSections.add(currentSection);
                totalSeatCount+=seatBluePrint[index][j];
            }

            currentRow.setListOfSections(currentListOfSections);
            listOfRows.add(currentRow);
        }
        TheaterService theaterService = new Theater("Grand Theater", listOfRows, totalSeatCount);

        return theaterService;
    }

    private int populateSeats(int i) {
        List<Seat> listOfSeats = new ArrayList<>(i);

        for (int j = 0; j < i; j++) {
            listOfSeats.add(new Seat(false));
        }

        return listOfSeats.size();
    }

    @Override
    public void printElements(int[][] layout){
        for (int index = 0; index < layout.length; index++) {
            System.out.println(Arrays.toString(layout[index]));
        }
    }


    @Override
    public int availableSeats(TheaterService theaterService){
        int availableSeats = 0;

        for (int i = 0; i < theaterService.getListOfRows().size(); i++) {
            Row currentRow = theaterService.getListOfRows().get(i);

            for (int j = 0; j < currentRow.getListOfSections().size(); j++) {
                Section currentSection = currentRow.getListOfSections().get(j);
                availableSeats += currentSection.getAvailableSeats();
            }
        }

        return availableSeats;
    }
    @Override
    public boolean splitNeeded(int seatsRequested, TheaterService theaterService) {

        for (int i = 0; i < theaterService.getListOfRows().size(); i++) {
            Row currentRow = theaterService.getListOfRows().get(i);
            for (Section s:currentRow.getListOfSections()) {
                if (s.getAvailableSeats() >= seatsRequested){
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "theaterName='" + theaterName + '\'' +
                ", listOfRows=" + listOfRows +
                '}';
    }
}
