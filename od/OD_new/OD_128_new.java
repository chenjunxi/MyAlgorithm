package com.od.OD.OD130;

import java.util.Arrays;
import java.util.Scanner;

/*
* 新员工考试 100分 23.Q1
求分数的组合情况
100
输出：1  只有一种情况，就是全部答对

解法：回溯法 ，达到分数和累积答错3次终止
* */
class OD_128_new {
    public static int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        //先初始化所有题目的分数
        int[] num = new int[25];

        for (int i = 0; i < num.length; i++) {
            if (i < 10) {
                num[i] = 2;
            } else if (i < 20) {
                num[i] = 4;
            } else {
                num[i] = 8;
            }
        }
        dfs(num, 0, 0, 0, N);
        System.out.println(result);
    }

    public static void dfs(int[] num, int index, int score, int error_count, int N) {
        if (score == N) {
            result++;
            return;
        }
        if (score > N || error_count >= 3) return;

        for (int i = index; i < num.length; i++) {
            score += num[i];
            dfs(num, i + 1, score, error_count, N);
            score -= num[i];
            error_count++;
        }
    }
}