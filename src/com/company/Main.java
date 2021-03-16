package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final Random random = new Random();
    static final Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        //number of amplicons (intervals)
        DM minute = new DM();

        System.out.printf("How many amplicons?  ");
        int amplicon = scan.nextInt();
        for (int i = 0; i < amplicon; i++) {
            //chromosome of interval
            System.out.printf("Chromosome of interval: ");
            int chromosome = scan.nextInt();
            //start position of interval
            System.out.printf("Start position of interval: ");
            int start = scan.nextInt();
            //end position of interval
            System.out.printf("End position of interval: ");
            int end = scan.nextInt();
            //orientation of interval (0 or 1)
            System.out.printf("Orientation of interval: ");
            int orientation = scan.nextInt();
            boolean orientate = false;
            if (orientation == 0 || orientation != 1) {
                orientate = false;
            } else if (orientation == 1) {
                orientate = true;
            }
            //repeat from #2 until all amplicons are stored.
            Coordinate coordinate = new Coordinate(chromosome, start, end, orientate);
            minute.addAmplicon(coordinate);
            System.out.println(minute);


        }

        alterMinute(minute, 4);

//        minute.addAmplicon();


        //        countdown(5);
//        int fib = fibonacci(20);
//        System.out.println(fib);
//        mutate(new StringBuilder("TGAGC"), 4);
    }


//    public static void countdown(int n) {
//        if (n == 0) {
//            System.out.println("0");
//        } else {
//            System.out.println(n);
//            countdown(n - 1);
//        }
//    }
//    public static int fibonacci(int n)  {
//        if(n == 0)
//            return 0;
//        else if(n == 1)
//            return 1;
//        else
//            return fibonacci(n - 1) + fibonacci(n - 2);
//    }

//    public static void mutate(StringBuilder DNA, int generations) {
//        if (generations == 0) {
//            System.out.println(DNA + "," + 0);
//        } else {
//            System.out.println(DNA + "," + generations);
//            char nucleo = ' ';
//            int randNucleotide = random.nextInt(4);
//            int index = random.nextInt(DNA.length());
//            System.out.println(randNucleotide);
//            if (randNucleotide == 0) {
//                nucleo = 'A';
//                System.out.println(nucleo);
//            } else if (randNucleotide == 1) {
//                nucleo = 'T';
//                System.out.println(nucleo);
//            } else if (randNucleotide == 2) {
//                nucleo = 'C';
//                System.out.println(nucleo);
//            } else if (randNucleotide == 3) {
//                nucleo = 'G';
//                System.out.println(nucleo);
//            }
//            DNA.setCharAt(index, nucleo);
//            mutate(DNA, generations - 1);
//        }


    public static void alterMinute(DM doubleMinute, int randomGenerations) {
        int randomIndex = random.nextInt(2);
        int chromosome = random.nextInt(22) + 1;

        //hashmap (chromsome key, value is size)
        //generate chromosome start position
        Map<Integer, Integer> chromosomes = new HashMap<>();
        chromosomes.put(1, 248956422);
        chromosomes.put(2, 242193529);
        chromosomes.put(3, 198295559);
        chromosomes.put(4, 190214555);
        chromosomes.put(5, 181538259);
        chromosomes.put(6, 170805979);
        chromosomes.put(7, 159345973);
        chromosomes.put(8, 145138636);
        chromosomes.put(9, 138394717);
        chromosomes.put(10, 133797422);
        chromosomes.put(11, 135086622);
        chromosomes.put(12, 133275309);
        chromosomes.put(13, 114364328);
        chromosomes.put(14, 107043718);
        chromosomes.put(15, 101991189);
        chromosomes.put(16, 90338345);
        chromosomes.put(17, 83257441);
        chromosomes.put(18, 80373285);
        chromosomes.put(19, 58617616);
        chromosomes.put(20, 64444167);
        chromosomes.put(21, 46709983);
        chromosomes.put(22, 50818468);


        int start = random.nextInt(chromosomes.get(chromosome)) + 1;
        int end = start + random.nextInt(900000) + 100001;
        boolean orientate = false;
        Coordinate coord = new Coordinate(chromosome, start, end, orientate);

        if (randomGenerations == 0) {
            System.out.println(doubleMinute);
        } else if (randomIndex == 0) {
            System.out.println(doubleMinute.addAmplicon(coord));
            alterMinute(doubleMinute, randomGenerations - 1);
            alterMinute(doubleMinute, randomGenerations - 1);

        }
//        } else if (randomIndex == 2) {
//        //    System.out.println(doubleMinute.removeAmplicon(coord));
//            alterMinute(doubleMinute, randomGenerations - 1);
//
        else if (randomIndex == 1) {
            int dm = random.nextInt(doubleMinute.size());
            doubleMinute.changeRandAmplicon(dm);
            alterMinute(doubleMinute, randomGenerations - 1);
            alterMinute(doubleMinute, randomGenerations - 1);
        }
        //  alterMinute(doubleMinute, randomGenerations - 1);
        //   System.out.println(doubleMinute + "/t" + coord.getStart() + "/t" + coord.getEnd());
    }

}

//research Newick format, get removeAmplicon working. (revisit that)
//add another recursive call, can duplicate current recursive call, simulate creating 2 DMs from 1.
//goal: simulate the FASTQ, get the tree from that.
//show your input coordinates, then show what coordinates were replicated, ultimate goal is DM sequencing data
//