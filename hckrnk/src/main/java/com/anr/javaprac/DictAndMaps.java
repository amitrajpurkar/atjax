package com.anr.javaprac;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictAndMaps {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Map<String, Integer> phoneBook = new HashMap<String, Integer>();
        phoneBook.put("key", Integer.valueOf(9));

        Integer ii = phoneBook.getOrDefault("key", Integer.valueOf("0"));
        ii.toString();
        ii.compareTo(0);

    }

    private void fromHckrRnk() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
        }
        while (in.hasNext()) {
            String s = in.next();
            // Write code here
        }
        in.close();
    }

}
