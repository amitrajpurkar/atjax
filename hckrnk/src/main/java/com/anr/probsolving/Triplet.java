package com.anr.probsolving;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Triplet {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> comparisonList = new ArrayList<Integer>();
        int lenA = a.size();
        int lenB = b.size();
        int lenLongestList = lenA > lenB ? lenA : lenB;
        AtomicInteger biggerAs = new AtomicInteger();
        AtomicInteger biggerBs = new AtomicInteger();

        for (int i = 0; i < lenLongestList; i++) {
            if (a.get(i).compareTo(b.get(i)) > 0) {
                biggerAs.incrementAndGet();
            } else if (a.get(i).compareTo(b.get(i)) < 0) {
                biggerBs.incrementAndGet();
            }
        }
        comparisonList.add(Integer.valueOf(biggerAs.get()));
        comparisonList.add(Integer.valueOf(biggerBs.get()));

        return comparisonList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(result.stream().map(Object::toString).collect(joining(" ")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
