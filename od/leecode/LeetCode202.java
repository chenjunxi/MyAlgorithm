package com.leecode;

import java.util.HashSet;

public class LeetCode202 {
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        int a = 19;

        while (true) {
            int next = getNext(a);

            if (next == 1) {
                System.out.println(true);
                break;
            }

            if (set.contains(next)) {
                System.out.println(false);
                break;
            } else {
                set.add(next);
            }

        }

    }

    public static int getNext(int n) {


        int sum = 0;
        while (n > 0) {
            int yushu = n % 10;
            sum += yushu * yushu;
            n = n / 10;
        }
        return sum;
    }
}
