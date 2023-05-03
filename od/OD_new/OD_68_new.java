package com.od.OD.OD130;

import java.util.*;
import java.util.stream.Collectors;
/*
* 士兵过河
*
* */
class OD_68_new {
    //二叉树定义
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val;}
    }

    public static void main(String[] args) {
        // 输入处理
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int T = in.nextInt();
        in.nextLine();

        Integer[] a = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.sort(a);

        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                dp[0] = a[0];
                if (dp[0] > T) {
                    System.out.println("0 0");
                    return;
                }
            } else if (i == 1) {
                dp[1] = a[1];
            }
            else {
                dp[i] = Math.min(dp[i - 1] + a[i] + a[0], dp[i - 2] + a[0] + a[i] + a[1] + a[1]);
            }
            if (dp[i] > T) {
                System.out.println(i + " " + dp[i - 1]);
                return;
            }
        }

        System.out.println(N + " " + dp[N - 1]);
    }

}