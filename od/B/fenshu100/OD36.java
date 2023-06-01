package com.od.B.fenshu100;

import java.util.Arrays;
import java.util.Scanner;

public class OD36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] num = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = i + 1; j < s.length; j++) {
                int count = Math.abs(num[i] + num[j]);
                if (count < min) {
                    x = num[i];
                    y = num[j];
                    min = count;
                }
            }
        }
        System.out.print(x + " " + y + " " + min);
    }
}
