package com.od.OD.bei;

import java.util.Scanner;

/*
* 西天取经 求最小移动次数达到区域的右下角
4 4 10 4*4区域 10表示前后移到允许的高度差
10 20 30 40 每个点的高度
100 120 140 160
200 230 260 290
300 400 500 600
输出6
* */
class OD_125 {
    public static int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; //前后左右移到四种场景
    public static int res = Integer.MAX_VALUE, sum = 0;
    public static boolean[][] visited;
    //爆发能力使用次数
    public static int count = 0;

    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        visited = new boolean[m][n];
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        dfs(matrix, 0, 0, k);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);

    }

    public static void dfs(int[][] matrix, int x, int y, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        //终止条件
        if (x == m - 1 && y == n - 1) {
            res = Math.min(res, sum);
            return;
        }

        if (visited[x][y])
            return;
        visited[x][y] = true;

        for (int[] d : directions) {
            int x1 = x + d[0];
            int y1 = y + d[1];
            if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n) {
                continue;
            }
            if (Math.abs(matrix[x1][y1] - matrix[x][y]) <= k) {
                sum++;
                dfs(matrix, x1, y1, k);
                sum--;
            } else { //有3次爆发使用，爆发可以不限制前后高度差
                if (count > 2)
                    continue;
                count++;
                sum++;
                dfs(matrix, x1, y1, k);
                count--;
                sum--;
            }
        }
        visited[x][y] = false;
    }

}