package com.anr.algorithms;

public class Staircase {

    // Complete the staircase function below.
    static void staircase(int n) {
        String SPACE = " ";
        String HASH = "#";
        String line = "";
        for (int i = 0; i < n; i++) {
            line = "";
            for (int j = 0; j < n - i - 1; j++) {
                line += SPACE;
            }
            for (int k = 0; k <= i; k++) {
                line += HASH;
            }
            System.out.println(line);
        }
    }

    // private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // int n = scanner.nextInt();
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        //
        // staircase(n);
        //
        // scanner.close();

        staircase(5);
    }
}
