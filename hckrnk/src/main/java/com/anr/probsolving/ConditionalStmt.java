package com.anr.probsolving;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConditionalStmt {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(timeConversion("07:05:45PM"));
    }

    private static String timeConversion(String input12HrFormat) {
        String timeIn24HrFormat = null;
        String DATE_FORMAT_12hr = "hh:mm:ssa";
        String DATE_FORMAT_24hr = "HH:mm:ss";
        try {
            Date actualDate = new SimpleDateFormat(DATE_FORMAT_12hr).parse(input12HrFormat);
            timeIn24HrFormat = new SimpleDateFormat(DATE_FORMAT_24hr).format(actualDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
        }

        return timeIn24HrFormat;
    }

    private static void conditionalStmtProblem() {
        int N = 24;
        String wierd = "Weird";
        String notWierd = "Not Weird";

        boolean isOddNumber = N % 2 != 0;
        boolean isEvenNumber = N % 2 == 0;
        if (isOddNumber) {
            System.out.println(wierd);
        } else if (isEvenNumber && 2 <= N && N <= 5) {
            System.out.println(notWierd);
        } else if (isEvenNumber && 6 <= N && N <= 20) {
            System.out.println(wierd);
        } else if (isEvenNumber && N > 20) {
            System.out.println(notWierd);
        }
    }

    private static void fromHckrRnk() {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();
    }
}
