package com.od.OD.OD100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OD_35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //使用数组存放{价格，差价}。list装数组，然后自定义排序。然后输出

        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            int diffPice = Math.abs(price - x);
            list.add(new int[]{price, diffPice});
        }

        list.sort((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = list.get(i)[0];
        }

        Arrays.sort(ints);

        for (int i = 0; i < k - 1; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println(ints[k - 1]);

    }
}
