package com.od.B.fenshu100;

import java.util.Arrays;
import java.util.Scanner;

/*
矩阵稀疏 送分题啊，题目意思恶心人，实际很简单


每行或列中出现0个数大于等于一半，就认为行稀疏
找出矩阵稀疏行和稀疏列的个数
3 3
1 0 0
0 1 0
0 0 1
输出
3
3

5 3
-1 0 1
0 0 0
-1 0 0
0 -1 0
0 0 0

思路 用两个数组分别记下每行或列出现0的个数
* */
public class OD59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int[] rowZeroCount = new int[m];
        int[] colZeroCount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (in.nextInt() == 0) {
                    rowZeroCount[i]++;
                    colZeroCount[j]++;
                }
            }
        }

        System.out.println(Arrays.stream(rowZeroCount).filter(val -> val >= n / 2).count());
        System.out.println(Arrays.stream(colZeroCount).filter(val -> val >= m / 2).count());
    }
}