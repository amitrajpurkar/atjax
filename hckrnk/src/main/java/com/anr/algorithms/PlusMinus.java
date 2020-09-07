package com.anr.algorithms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        BigDecimal listSize = new BigDecimal(arr.length);
        int scaleDesired = 6;
        BigDecimal numOfPositives = BigDecimal.ZERO;
        BigDecimal numOfNegatives = BigDecimal.ZERO;
        BigDecimal numOfZeros = BigDecimal.ZERO;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                numOfPositives = numOfPositives.add(BigDecimal.ONE);
            } else if (arr[i] < 0) {
                numOfNegatives = numOfNegatives.add(BigDecimal.ONE);
            } else if (arr[i] == 0) {
                numOfZeros = numOfZeros.add(BigDecimal.ONE);
            }
        }
        System.out.println(numOfPositives.divide(listSize, scaleDesired, RoundingMode.HALF_UP).toPlainString());
        System.out.println(numOfNegatives.divide(listSize, scaleDesired, RoundingMode.HALF_UP).toPlainString());
        System.out.println(numOfZeros.divide(listSize, scaleDesired, RoundingMode.HALF_UP).toPlainString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // int n = scanner.nextInt();
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        // scanner.nextDouble();
        // scanner.next(Pattern.compile("\\w \\s \\W+"));
        // scanner.nextLine();
        //
        // int[] arr = new int[n];
        //
        // String[] arrItems = scanner.nextLine().split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        //
        // for (int i = 0; i < n; i++) {
        // int arrItem = Integer.parseInt(arrItems[i]);
        // arr[i] = arrItem;
        // }

        int[] arr = { -4, 3, -9, 0, 4, 1 };
        plusMinus(arr);

        // arr = {13, 7, 6, 45, 21, 9, 101, 102};

        Arrays.sort(arr);

        System.out.printf("Modified arr[] : %s", Arrays.toString(arr));

        // scanner.close();
    }
}
