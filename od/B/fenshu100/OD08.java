package com.od.B.fenshu100;

import java.util.Arrays;
import java.util.Scanner;

public class OD08 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(",");
        int[] M = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        int R = sc.nextInt();

        int len = M.length;
        Arrays.sort(M);
        int sum = 0;
        for (int i = len - 1; i >= 2; i--) {
            if (M[i] > R) {
                continue;
            }
            for (int j = i - 1; j >= 1; j--) {
                if (M[i] + M[j] > R) {
                    continue;
                }
                for (int k = j - 1; k >= 0; k--) {
                    int temp = M[i] + M[j] + M[k];
                    if (temp <= R && temp > sum) {
                        sum = temp;
                    }
                }
            }
        }

        System.out.println(sum == 0 ? -1 : sum);
    }
}
