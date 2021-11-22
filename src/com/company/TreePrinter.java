package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreePrinter {
    public static Node<Amplicon> test1() {
        Node<Amplicon> root = new Node<Amplicon>(2, 3345, 33344, true);
        Node<Amplicon> n11 = new Node<Amplicon>(7, 332, 4554, false);
        Node<Amplicon> n12 = new Node<Amplicon>(5, 2202, 35566, true);
        Node<Amplicon> n21 = new Node<Amplicon>(1, 566676, 1000044, true);
        Node<Amplicon> n22 = new Node<Amplicon>(6, 444504, 3443234, false);
        Node<Amplicon> n23 = new Node<Amplicon>(3, 11234, 55643, true);
        Node<Amplicon> n24 = new Node<Amplicon>(11, 13203, 3003495, false);
        Node<Amplicon> n31 = new Node<Amplicon>(21, 3324, 9985, true);
        Node<Amplicon> n32 = new Node<Amplicon>(8, 10349, 23343, false);
        Node<Amplicon> n33 = new Node<Amplicon>(4, 22345, 66554, false);
        Node<Amplicon> n34 = new Node<Amplicon>(5, 6964, 9884, true);
        Node<Amplicon> n35 = new Node<Amplicon>(22, 99865, 100354, false);
        Node<Amplicon> n36 = new Node<Amplicon>(15, 54989, 70452, false);
        Node<Amplicon> n37 = new Node<Amplicon>(17, 44342, 56000, true);
        Node<Amplicon> n38 = new Node<Amplicon>(20, 56697, 100024, true);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }

    public static Node<Integer> test2() {
        Node<Integer> root = new Node<Integer>(2, 3345, 33344, true);
        Node<Integer> n11 = new Node<Integer>(7, 332, 4554, false);
        Node<Integer> n12 = new Node<Integer>(5, 2202, 35566, true);
        Node<Integer> n21 = new Node<Integer>(1, 566676, 1000044, true);
        Node<Integer> n22 = new Node<Integer>(3, 11234, 55643, true);
        Node<Integer> n23 = new Node<Integer>(22, 99865, 100354, false);
        Node<Integer> n31 = new Node<Integer>(15, 54989, 70452, false);
        Node<Integer> n32 = new Node<Integer>(21, 3324, 9985, true);
        Node<Integer> n33 = new Node<Integer>(20, 56697, 100024, true);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }

    public static void main(String[] args) {

        BTreePrinter.printNode(test1());
        BTreePrinter.printNode(test2());

    }
}

class Node<T extends Comparable<?>> {
    Node<T> left, right;
    int data1;
    int data2;
    boolean data3;
    int data;

    public Node(int data, int data1, int data2, boolean data3) {
        this.data = data;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    public static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data + " " + node.data1 + " " + node.data2 + " "  + node.data3);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    public static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    public static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    public static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}