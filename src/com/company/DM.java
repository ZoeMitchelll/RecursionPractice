package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class DM {
    private HashSet<DM> children;
    private HashSet<Amplicon> amplicons;
    static final Random random = new Random();
    static int maxChildren = 3;
    static int maxCoordinates = 4;
    final String prefix;
    static int letter = 0;
    static StringBuilder buffer = new StringBuilder(500);


    public DM() {
        amplicons = new HashSet<>();
        children = new HashSet<>();
        prefix = generatePrefix();
        letter++;
    }

    public DM(int coordinates) {
        amplicons = new HashSet<>();
        while(amplicons.size()!=coordinates){
            amplicons.add(new Amplicon());
        }
        children = new HashSet<>();
        prefix = generatePrefix();
        letter++;
    }

    //returns 26^2 unique representations for DM
    String generatePrefix(){
        int iteration = letter/26;
        char c = (char) ((letter%26) + 97);
        return String.valueOf((char) (97+iteration)) + String.valueOf(c);
    }
    public String getPrefix(){
        return prefix;
    }

    public String toString() {
        print( "", "");
        return buffer.toString();
    }

    private void print(String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(getPrefix());
        buffer.append('\n');
        for (Iterator<DM> it = children.iterator(); it.hasNext(); ) {
            DM next = it.next();
            if (it.hasNext()) {
                next.print(childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

    HashSet<DM> populateChildren(int childrenNum){
        HashSet<DM> treeLevel = new HashSet<>();
        while(treeLevel.size()!=childrenNum){
            int coordinates = random.nextInt(maxCoordinates)+1;
            treeLevel.add(new DM(coordinates));
        }
        return treeLevel;
    }

    public void alterMinute(int randomGenerations){
        if(0 == randomGenerations){
            return;
        }
        if(children.size()==0){
            setChildren(populateChildren(random.nextInt(maxChildren)+1));
        }
        Iterator<DM> it = children.iterator();
        while(it.hasNext()){
            DM thisChild = it.next();
            thisChild.alterMinute(randomGenerations-1);
        }
    }

    private void setChildren(HashSet<DM> newChildren) {
        children = newChildren;
    }
}

//driver code, create an object of type DM.
//Populate with 2 amplicon objects.

// given a tree in Newick format, make a program that will print the tree to the screen.
//make the program print a Newick format, simulate a DM, here's the recursion tree, print in Newick format.