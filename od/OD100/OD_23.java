package com.od.OD.OD100;

import scala.Int;

import java.util.Scanner;
import java.util.TreeSet;

public class OD_23 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int count = Integer.parseInt(split[2]);

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < count; i++) {
            set.add(a * (count - i) + b * i);
        }

        System.out.println(set);

    }
}
