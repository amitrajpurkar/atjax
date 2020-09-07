package com.anr.probsolving;

import static java.lang.Math.abs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDiff {
    public static void main(String[] args) throws IOException {
        System.out.println("entering main method");

        int result = diagonalDifference(convertArgsToArray(args));

        System.out.println(String.valueOf(result));
    }

    public static List<List<Integer>> convertArgsToArray(String[] args) {
        System.out.println(Arrays.toString(args));
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // int arraySize = Integer.parseInt(bufferedReader.readLine().trim());
        int arraySize = Integer.parseInt(args[0]);
        System.out.println(arraySize);

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(11, 2, 4));
        arr.add(Arrays.asList(4, 5, 6));
        arr.add(Arrays.asList(10, 8, -12));

        // List<Integer> innrArr = new ArrayList<>();
        // int setStartPos = 1;
        // while (setStartPos < args.length) {
        // for (int i = 0; i < arraySize; i++) {
        // innrArr.add(Integer.parseInt(args[i + setStartPos]));
        // }
        // arr.add(innrArr);
        // setStartPos += arraySize;
        // }

        // IntStream.range(0, arraySize).forEach(i -> {
        // try {
        // arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split("
        // ")).map(Integer::parseInt)
        // .collect(toList()));
        // } catch (IOException ex) {
        // throw new RuntimeException(ex);
        // }
        // });
        System.out.println(arr);
        return arr;
    }

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int matrixLength = arr.size();
        int diagonalLeftToRight = 0;
        int diagonalRightToLeft = 0;

        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixLength; j++) {
                if (i == j) {
                    diagonalLeftToRight += arr.get(i).get(j).intValue();
                }
            }
        }
        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixLength; j++) {
                if (i == j) {
                    diagonalRightToLeft += arr.get(i).get(matrixLength - 1 - j).intValue();
                }
            }
        }

        return abs(diagonalLeftToRight - diagonalRightToLeft);
    }

}
