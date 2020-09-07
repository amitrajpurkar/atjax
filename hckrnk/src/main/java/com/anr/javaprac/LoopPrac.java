package com.anr.javaprac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoopPrac {
    public static void main(String[] argh) {
        // int t = in.nextInt();// tells how many lines are following..
        List<Double> numSeries = new ArrayList<>();
        // for (int i = 0; i < t; i++) {
        // int a = in.nextInt();
        // int b = in.nextInt();
        // int n = in.nextInt();
        printEachSeries(0, 2, 10);
        numSeries = new ArrayList<>();

        // printEachSeries(5, 3, 5);
        // }

    }

    public static void printEachSeries(int a, int b, int n) {
        List<Double> numSeries = new ArrayList<>();
        double nthElement = 0;
        double partBvalue = 0;
        String seriesString = "";
        for (int i = 0; i < n; i++) {
            partBvalue = 0;
            for (int j = 0; j < i + 1; j++) {
                partBvalue += Math.pow(2, j) * b;
            }
            nthElement = a + partBvalue;
            numSeries.add(nthElement);
        }
        for (Double eachElem : numSeries) {
            seriesString += eachElem.longValue() + " ";
        }

        System.out.println(seriesString);
    }

    private void hckrnkMethod() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
        }
        in.close();
    }
}