package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
补种胡杨树
10
4
2 3 6 8
2

思路：统计哪个死节点左右的连续1个数，哪个多先补哪个点。
    注意有特殊情况，就是不补树。
* */
public class OD14 {

    public static int max = -1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //总共棵树
        int m = sc.nextInt();   //未成活的棵树

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        int[] dead = new int[m];
        for (int i = 0; i < m; i++) {
            int nextInt = sc.nextInt();
            dp[nextInt] = 0;
            dead[i] = nextInt;
        }

        int k = sc.nextInt();

        if (k == 0) {


            return;
        }

        System.out.println(Arrays.toString(dp));


        for (int j = 0; j < k; j++) {

            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 0; i < dead.length; i++) {
                int i1 = dead[i];
                if (i1 == 1) continue;
                int count = getOne(dp, i1);
                list.add(new int[]{count, i1});
                max = Math.max(max, count + 1);
            }

            list.sort((a, b) -> {
                return b[0] - a[0];
            });

            if (list.size() == 0) {
                System.out.println(n);
                return;
            }

            int[] ints = list.get(0);
            dp[ints[1]] = 1;

        }


        System.out.println(max);
    }

    private static int getOne(int[] dp, int index) {
        int left = 0, right = 0;

        int temp = index;
        while (temp > 1) {
            temp--;
            if (dp[temp] == 1) {
                left++;
            } else {
                break;
            }

        }

        while (index < dp.length - 1) {
            index++;
            if (dp[index] == 1) {
                right++;
            } else {
                break;
            }

        }

        return left + right;

    }
}
