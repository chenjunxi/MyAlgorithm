package com.od.B.fenshu200;

import java.util.Arrays;
import java.util.Scanner;

public class OD11 {
    public static int[] files;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        files = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(files);

        int min = 0;
        int max = files.length + 1;

        while (min < max) {

            int mid = (min + max) / 2;
            if (check(mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

        System.out.println(min);

    }

    public static boolean check(int mid) {

        int[] ints = new int[mid];
        for (int i = 0; i < mid; i++) {
            ints[i] = 500;
        }

        for (int i = files.length - 1; i >= 0; i--) {
            int f = files[i];
            Arrays.sort(ints);
            if (ints[mid - 1] >= f) {
                ints[mid - 1] -= f;
            } else {
                return false;
            }
        }

        return true;
    }
}
