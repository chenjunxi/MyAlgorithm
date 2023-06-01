package com.od.B.fenshu100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OD47 {
    public static void main(String[] args) {

        int b, c;
        int[] a = new int[10];
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        b = sc.nextInt();
        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int s = 0;
            while (a[i] > 0) {
                s += a[i] % 256;
                a[i] /= 256;
            }
            s %= b;
            if (s < c) {
                count.put(s, count.getOrDefault(s, 0) + 1);
            }
        }
        int ans = 0;
        for (int value : count.values()) {
            ans = Math.max(ans, value);
        }
        System.out.println(ans);
    }
}
