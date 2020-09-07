package com.anr.algorithms;

import java.util.Arrays;

public class BirthdayCakeCandles {

    public static void main(String[] args) {
        int result = birthdayCakeCandles(getOneArray());
        System.out.println(result);
    }

    static int birthdayCakeCandles(int[] ar) {
        int numOfTalls = 1;
        Arrays.sort(ar);
        int biggerNumber = 0;
        int currentNumber = 0;
        for (int i = 0; i < ar.length; i++) {
            currentNumber = ar[i];
            if (currentNumber >= biggerNumber) {
                if (currentNumber == biggerNumber) {
                    numOfTalls++;
                }
                biggerNumber = currentNumber;
            }
        }
        return numOfTalls;
    }

    static int[] getOneArray() {
        int[] sample1 = { 3, 2, 1, 3 };
        return sample1;
    }

    static int[] getLongArr() {
        int[] sample2 = {};

        return sample2;
    }

}
