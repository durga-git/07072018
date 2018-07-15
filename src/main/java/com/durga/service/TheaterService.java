package com.durga.service;

import com.durga.domain.Row;

import java.util.List;

public interface TheaterService {
    List<Row> getListOfRows();

    int getTheaterCapacity();

    TheaterService buildTheater(int[][] theaterBluePrint);

    void printElements(int[][] layout);

    int availableSeats(TheaterService theaterService);

    boolean splitNeeded(int seatsRequested, TheaterService theaterService);

    @Override
    String toString();
}
