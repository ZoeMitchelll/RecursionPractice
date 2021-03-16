package com.company;

import java.util.ArrayList;

public class DM {
    private ArrayList<Coordinate> startCoord;


    public DM() {
        startCoord = new ArrayList<>();
    }

    public void setStartCoord(ArrayList<Coordinate> startCoord) {
        this.startCoord = startCoord;
    }

    public ArrayList<Coordinate> addAmplicon(Coordinate coordinate) {
        startCoord.add(coordinate);
        return startCoord;
    }

    public ArrayList<Coordinate> removeAmplicon(Coordinate coordinate) {
        startCoord.remove(coordinate);
        return startCoord;
    }

    public Coordinate changeOrientation(Coordinate coordinate) {
        coordinate.setOrientation(!coordinate.getOrientation());
        return coordinate;
    }

    public Coordinate modifyCoordinate(Coordinate coordinate) {
        coordinate.setChromosome(coordinate.getChromosome());
        coordinate.setOrientation(coordinate.getOrientation());
        coordinate.setStart(coordinate.getStart());
        coordinate.setEnd(coordinate.getStart() + coordinate.getEnd());
        return coordinate;
    }

    public int size() {
        return startCoord.size();
    }

    public void changeRandAmplicon(int ampliconIndex) {
        startCoord.set(ampliconIndex, changeOrientation(startCoord.get(ampliconIndex)));
    }

    @Override
    public String toString() {
        return "DM{" + "startCoord=" + startCoord +
                '}';
    }
}

//driver code, create an object of type DM.
//Populate with 2 amplicon objects.

// given a tree in Newick format, make a program that will print the tree to the screen.
//make the program print a Newick format, simulate a DM, here's the recursion tree, print in Newick format.