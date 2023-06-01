package com.od.B.EX;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ODB19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        HashMap<Integer, HashSet<Integer>> matrix = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int d1 = in.nextInt();
            int d2 = in.nextInt();
            matrix.putIfAbsent(d1, new HashSet<>());
            matrix.putIfAbsent(d2, new HashSet<>());
            matrix.get(d1).add(d2);
        }

        for (Integer d1 : matrix.keySet()) {
            for (Integer d2 : matrix.get(d1)) {
                if (!matrix.get(d2).contains(d1)) {
                    System.out.println("False");
                    return;
                }
            }
        }
        System.out.println("True");
        return;
    }
}