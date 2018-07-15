package com.durga.domain;

import java.util.List;

public class Row {
    private String rowName;
    private List<Section> listOfSections;

    public Row(final String rowName, final List<Section> listOfSections) {
        this.rowName = rowName;
        this.listOfSections = listOfSections;
    }

    public Row() {
    }

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public List<Section> getListOfSections() {
        return listOfSections;
    }

    public void setListOfSections(List<Section> listOfSections) {
        this.listOfSections = listOfSections;
    }

    @Override
    public String toString() {
        return "Row{" +
                "rowName='" + rowName + '\'' +
                ", listOfSections=" + listOfSections +
                '}';
    }
}
