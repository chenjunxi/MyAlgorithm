package com.od.OD.OD130;

import java.util.Scanner;

/*
* 机器人
* */
class OD_56_new {
    private static final int[][] dic = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int k = 1;

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] matrix = new int[m][n];
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                matrix[x][y] = in.nextInt();
            }
        }

        // 起点可以是每一个位置
        int result = 0;
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                boolean[][] visited = new boolean[m][n];
                k = 1;
                bfs(matrix, visited, x, y);
                result = Math.max(k, result);
            }
        }
        System.out.print(result);

    }

    public static void bfs(int[][] matrix, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        //四个方向查看是否可行
        for (int[] d : dic) {
            int newX = x + d[0], newY = y + d[1];
            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length) {
                if (!visited[newX][newY] && Math.abs(matrix[x][y] - matrix[newX][newY]) <= 1) {
                    k++;
                    bfs(matrix, visited, newX, newY);
                }
            }
        }
    }

}