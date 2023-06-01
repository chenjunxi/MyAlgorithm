package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class OD40 {
    /**
     * 3 5
     * 8 4 3 2 10
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int dp[] = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp[i] = sc.nextInt();
            list.add(dp[i]);
        }

        Arrays.sort(dp);
        if (m >= n) {
            System.out.println(dp[n - 1]);
            return;
        }
        Collections.sort(list);
        int res = 0;
        for (int i = 0; i < m; i++) {
            int time = 0;
            for (int j = i; j < list.size(); j += m) {
                time += list.get(j);
            }
            res = Math.max(res, time);
        }
        System.out.println(res);

    }
}
