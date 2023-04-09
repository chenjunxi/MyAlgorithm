package com.od.OD.OD100;

import java.util.Arrays;
import java.util.Scanner;

public class OD_42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] ints = new int[m];
        for (int i = 0; i < m; i++) {
            ints[i] = sc.nextInt();
        }

        if (m > n) {
            System.out.println(-1);
            return;
        }

        int min = 1;
        int max = Arrays.stream(ints).max().getAsInt();

        if (m == n) {
            System.out.println(max);
            return;
        }

        while (min < max) {
            int mid = (min + max) >> 1;
            if (check(mid, ints) <= n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min);


    }

    private static int check(int mid, int[] ints) {
        int res = 0;
        for (int i = 0; i < ints.length; i++) {
            int anInt = ints[i];
            if (anInt % mid == 0) {
                res += anInt / mid;
            } else {
                res += anInt / mid + 1;
            }
        }
        return res;
    }
}
