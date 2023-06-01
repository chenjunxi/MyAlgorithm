package com.od.B.fenshu100;

import java.util.Scanner;

public class OD06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String numString = scanner.nextLine();
        String[] strings = numString.split(",");
        int n = strings.length;
        int[] preSum = new int[n];
        int[] endSum = new int[n];
        preSum[0] = 0;
        endSum[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + Integer.parseInt(strings[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            endSum[i] = endSum[i + 1] + Integer.parseInt(strings[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            if (preSum[i] == endSum[i]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}

