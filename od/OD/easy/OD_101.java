package com.od.OD.OD130;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
* Linux发行版的数量
求关联版本共有多少个
4
1 1 0 0
1 1 1 0
0 1 1 0
0 0 0 1
1表表示第i行和第j列是关联的

思路通过回溯所有的版本，存放在set中，set的大小即是所求值
就是求关联版本最多的数量
* */
class OD_101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = sc.nextInt();
            }
        }


        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (!set.contains(i)) {
                HashSet<Integer> temp = new HashSet<>(); //一次递归统计就是一个集中发行版
                check(dp, i, temp);
                max = Math.max(max, temp.size()); //所以set的大小就是发行版的数量，比较取最大的
                set.addAll(temp);
            }

        }

        System.out.println(max);

    }

    private static void check(int[][] dp, int index, HashSet<Integer> temp) {
        for (int i = 0; i < dp.length; i++) {
            if (temp.contains(i)) continue; //不能去掉，不然导致死递归

            if (i != index && dp[index][i] == 1) {
                temp.add(i);
                check(dp, i, temp);
            }

        }
    }

}