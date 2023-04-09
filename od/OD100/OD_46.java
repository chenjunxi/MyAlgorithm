package com.od.OD.OD100;

import java.util.Scanner;

public class OD_46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //装数据
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();

        System.out.println(dfs(nums, k - 1));
    }

    private static int dfs(int[][] nums, int k) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[k][i] != 0 && i != k) {
                max = Math.max(max, dfs(nums, i)); //递归，直到无依赖就是结束的地方
            }
        }
        return max + nums[k][k]; //kk是本身启动的时间
    }
}
