package com.company;

public class Coordinate implements Comparable<Object> {

    private int chromosome;
    private int start;
    private int end;
    private Boolean orientation;

    public Coordinate() {
        chromosome = 23;
        start = 0;
        end = 1;
        orientation = false;
    }

    public Coordinate(int chromosome, int start, int end, Boolean orientation) {
        this.chromosome = chromosome;
        this.start = start;
        this.end = end;
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "chr" + chromosome +
                ", " + start +
                ", " + end;
    }

    public int getChromosome() {
        return chromosome;
    }

    public void setChromosome(int chromosome) {
        this.chromosome = chromosome;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Boolean getOrientation() {
        return orientation;
    }

    public void setOrientation(Boolean orientation) {
        this.orientation = orientation;
    }
}
