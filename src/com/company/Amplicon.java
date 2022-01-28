package com.company;

import java.util.Random;

public class Amplicon {

    private int chromosome;
    private int start;
    private int end;
    private Boolean orientation;
    static final Random random = new Random();
    static final int MAX_END = 1000000000;

    public Amplicon() {
        chromosome = 23;
        start = 0;
        end = 1;
        orientation = false;
    }

    public Amplicon(int chromosome, int start, int end, Boolean orientation) {
        this.chromosome = chromosome;
        this.start = start;
        this.end = end;
        this.orientation = orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amplicon)) return false;
        Amplicon that = (Amplicon) o;
        //Coordinates are considered equal when there is overlap within an equal chromosome
        return getChromosome() == that.getChromosome() && hasOverlap(that);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "chr" + chromosome +
                ", " + start +
                ", " + end;
    }

    //Considered to be overlapping if either start is between the other's start and end
    boolean hasOverlap(Amplicon that){
        boolean thatOverlaps = start <= that.getStart() && that.getStart() <= end;
        boolean thisOverlaps = that.getStart() <= start && start < that.getEnd();
        return thatOverlaps || thatOverlaps;
    }

    public int getChromosome() {
        return chromosome;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
