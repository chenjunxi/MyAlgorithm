package com.od.OD.OD200;

import java.util.Scanner;

public class OD_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int count = 0;
        for (int i = n; i <= m; i++) {
            String string = Integer.toBinaryString(i);
            if (!string.contains("101")) {
                count++;
            }
        }

        System.out.println(count);
    }
}
