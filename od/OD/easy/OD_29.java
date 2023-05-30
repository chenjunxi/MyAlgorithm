package com.od.OD.OD130;

import java.util.Arrays;
import java.util.Scanner;

/*
 * MVP争夺战 和OD20一样
 *
 * */
public class OD_29 {
    static int[] cnt = new int[51];
    static int maxn = -1;
    static int minn = 51;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int max = 0;

        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = sc.nextInt();
            max += ints[i];
        }

        int min = Arrays.stream(ints).max().getAsInt();

        int res = -1;
        for (int i = min; i <= max; i++) {

            if (max % i == 0) {
                int[] temp = new int[max / i];
                if (check(ints, temp, i, 0)) {

                    res = i;
                    break;
                }
            }
        }

        System.out.println(res);


    }

    private static boolean check(int[] ints, int[] temp, int index, int target) {

        if (index == ints.length) {

            return true;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] + ints[index] <= target) {
                temp[i] = temp[i] + ints[index];
                if (check(ints, temp, index + 1, target)) {
                    return true;
                }
                temp[i] = temp[i] - ints[index];
            }
        }

        return false;

    }


}
