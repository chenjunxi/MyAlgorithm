package com.od.B.EX;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
* 代表团
* 意思能坐满车的方案
5,4,2,3,2,4,9
10

2,3,5 ,2,4,4
2,3,5 ,2,4,4 注意因为有2个团的数量是2，并不是重复

方法1：
动态规划就是背包问题，只不过没有价值
方法2：
回溯法
* */
public class ODB07 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        Integer[] nums = Arrays.stream(in.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        int target = Integer.parseInt(in.nextLine());
        int n = nums.length;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(list, path, nums, 0, target, 0);

        System.out.println(list.size());

    }

    private static void dfs(ArrayList<ArrayList<Integer>> list, ArrayDeque<Integer> path, Integer[] nums, int index, int target, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            sum += nums[i];
            dfs(list, path, nums, i + 1, target, sum);
            sum -= nums[i];
            path.removeLast();
        }
    }

    private static void dpDemo(Integer[] nums, int target, int n) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= target; j++) {
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                }
            }
        }

        System.out.println(dp[n][target]);
    }

}

