package com.anr.javaprac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LoopPrac {
    public static void main(String[] argh) {
        // printEachSeries(0, 2, 10);
        solve(12.00, 20, 8);// 15
        solve(15.50, 15, 10);// 19

        int[] arr = { 1, 4, 3, 2 };
        String str = reverseList(arr);
        System.out.println(str);

    }

    private static String reverseList(int[] arr) {
        List<String> cloneArr = new ArrayList<>();
        for (int i : arr) {
            cloneArr.add(Integer.valueOf(i).toString());
        }
        Collections.reverse(cloneArr);
        CharSequence space = " ";
        return String.join(space, cloneArr);
    }

    static void solve(double meal_cost, int tip_percent, int tax_percent) {
        double tip = meal_cost * (tip_percent / 100.00);
        double tax = meal_cost * (tax_percent / 100.00);
        double total = meal_cost + tip + tax;
        System.out.println(Math.round(total));
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