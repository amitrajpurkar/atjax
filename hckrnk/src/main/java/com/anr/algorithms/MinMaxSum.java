package com.anr.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Scanner;

public class MinMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        List<Long> seriesLessOne = null;
        LongSummaryStatistics stats = null;
        List<Long> sumsOfFour = new ArrayList<Long>();
        for (int i = 0; i < arr.length; i++) {
            seriesLessOne = new ArrayList<Long>();
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    seriesLessOne.add(Long.valueOf(arr[j]));
                }
            }
            // System.out.println(seriesLessOne);
            stats = seriesLessOne.stream().mapToLong(x -> x).summaryStatistics();
            sumsOfFour.add(Long.valueOf(stats.getSum()));
        }
        // System.out.println(sumsOfFour);

        LongSummaryStatistics minMax = sumsOfFour.stream().mapToLong(x -> x).summaryStatistics();
        System.out.println("" + minMax.getMin() + " " + minMax.getMax());
    }

    private static void separateEvenOddChars(String word) {
        StringBuilder ev = null;
        StringBuilder od = null;
        ev = new StringBuilder();
        od = new StringBuilder();
        for (int j = 0; j < word.length(); j++) {
            if (j % 2 == 0) {
                ev.append(word.charAt(j));
            } else {
                od.append(word.charAt(j));
            }
        }
        System.out.println(ev.toString() + " " + od.toString());
    }

    @SuppressWarnings("unused")
    private void revLoopProblem() {
        Scanner sc = new Scanner(System.in);
        StringBuilder ev = null;
        StringBuilder od = null;
        String word = null;

        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            word = sc.nextLine();
            ev = new StringBuilder();
            od = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                if (j % 2 == 0) {
                    ev.append(word.charAt(j));
                } else {
                    od.append(word.charAt(j));
                }
            }
            System.out.println(ev.toString() + " " + od.toString());
        }
        sc.close();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // int[] arr = new int[5];
        //
        // String[] arrItems = scanner.nextLine().split(" ");
        // String test = scanner.nextLine();
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        //
        // for (int i = 0; i < 5; i++) {
        // int arrItem = Integer.parseInt(arrItems[i]);
        // arr[i] = arrItem;
        // }
        //
        // miniMaxSum(arr);
        //
        // scanner.close();

        // int[] arr = { 1, 3, 5, 7, 9 };
        // 256741038 623958417 467905213 714532089 938071625

        int[] arr = { 256741038, 623958417, 467905213, 714532089, 938071625 };
        miniMaxSum(arr);

        separateEvenOddChars("Hacker");

        // 2063136757 2744467344
    }
}
