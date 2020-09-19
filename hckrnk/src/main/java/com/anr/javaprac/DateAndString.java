package com.anr.javaprac;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;

public class DateAndString {
    public static void main(String args[]) {
        System.out.println(findDay(8, 17, 2019));

        // System.out.println(formatCurr(12324.134, "u"));
        // System.out.println(formatCurr(12324.134, "c"));
        // System.out.println(formatCurr(12324.134, "f"));
        // System.out.println(formatCurr(12324.134, "i"));

        // System.out.println(strIntro("hello", "java"));

        // System.out.println(reverse("hello"));

        // checkDivisibleInts("Hello", "0");
        // checkDivisibleInts("10", "Hello");
        // checkDivisibleInts("10", "0");
        // checkDivisibleInts("2147483648", "2147483648");
        // checkDivisibleInts("10", "3");

        try {
            // System.out.println(power(3, 5));
            // System.out.println(power(2, 4));
            // System.out.println(power(0, 0));
            // System.out.println(power(-1, -2));
            System.out.println(power(-1, 3));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static long power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        } else if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        } else {
            return (long) Math.pow(n, p);
        }
    }

    public static void checkDivisibleInts(String x, String y) {
        try {
            int a = Integer.parseInt(x);
            int b = Integer.parseInt(y);

            int division = a / b;
            System.out.println(division);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(ArithmeticException.class.getName() + " : / by zero");
        } catch (NumberFormatException e) {
            System.out.println(InputMismatchException.class.getName());
        }
    }

    public static String reverse(String s) {
        StringBuilder bldr = new StringBuilder(s).reverse();
        return bldr.toString();
    }

    public static String strIntro(String partA, String partB) {
        String desired = null;
        int sumOfLen = partA.length() + partB.length();
        System.out.println(sumOfLen);

        if (partA.compareTo(partB) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        desired = partA.replaceFirst(String.valueOf(partA.charAt(0)), String.valueOf(partA.charAt(0)).toUpperCase())
                .concat(" ").concat(partB.replaceFirst(String.valueOf(partB.charAt(0)),
                        String.valueOf(partB.charAt(0)).toUpperCase()));

        return desired;
    }

    public static String formatCurr(double currencyValue, String countryCode) {
        NumberFormat nf = null;
        String currString = null;
        if ("c".equalsIgnoreCase(countryCode)) {
            nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
            currString = nf.format(currencyValue);
        } else if ("u".equalsIgnoreCase(countryCode)) {
            nf = NumberFormat.getCurrencyInstance(Locale.US);
            currString = nf.format(currencyValue);
        } else if ("i".equalsIgnoreCase(countryCode)) {
            nf = NumberFormat.getCurrencyInstance(Locale.ROOT);
            currString = nf.format(currencyValue);
            currString = "Rs." + currString.substring(2);
        } else if ("f".equalsIgnoreCase(countryCode)) {
            nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
            currString = nf.format(currencyValue);
        }

        return currString;
    }

    public static String findDay(int month, int day, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        Date dt = cal.getTime();
        SimpleDateFormat fmt = new SimpleDateFormat("EEEE");
        return fmt.format(dt).toUpperCase();

    }
}
