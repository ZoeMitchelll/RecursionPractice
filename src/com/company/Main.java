package com.company;

import java.util.*;

public class Main {
    static final Random random = new Random();
    static final Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        //generate random DM with specified number of amplicons (intervals)
        System.out.printf("How many amplicons would you like to simulate per DM?  ");
        int amplicon = scan.nextInt();
        DM minute = generateDoubleMinute(amplicon);

        //simulate a specified amount of generations for minute
        System.out.printf("How many generations of DM would you like to simulate (0 will return the original DM)?   ");
        int generations = scan.nextInt();
        minute.alterMinute(generations);
        System.out.println(minute);
    }

    static DM generateDoubleMinute(int amplicons) {
        if (amplicons == 0) {
            return new DM();
        }
        return new DM(amplicons);
    }
}

//research Newick format, get removeAmplicon working. (revisit that)
//add another recursive call, can duplicate current recursive call, simulate creating 2 DMs from 1.
//goal: simulate the FASTQ, get the tree from that.
//show your input coordinates, then show what coordinates were replicated, ultimate goal is DM sequencing data
//