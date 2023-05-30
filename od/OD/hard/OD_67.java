package com.od.OD.bei;

import java.util.Scanner;

/*
 * 基站维护最短距离
 输入描述：

站点数n和各站点之间的距离（均为整数）。如：
3 {站点数}
0 2  l  {站点1到各站点的路程}
1 0 2  {站点2到各站点的路程}
2 1 0  {站点3到各站点的路程} 
 
输出描述：

3
 * */
class OD_67 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num <= 1) {
            System.out.println(0);
        }
        int[][] arr = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        boolean visited[] = new boolean[num];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < num; i++) {
            visited[i] = true;
            int temp = dfs(arr, visited, i, arr[0][i]);
            visited[i] = false;
            min = Math.min(temp, min);
        }
        System.out.println(min);
    }

    public static int dfs(int[][] arr, boolean[] visited, int curIndex, int len) {
        visited[curIndex] = true;
        if (judge(visited)) {
            visited[curIndex] = false;
            return len + arr[curIndex][0];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= arr.length - 1; i++) {
            if (visited[i]) {
                continue;
            }
            int temp = dfs(arr, visited, i, len + arr[curIndex][i]);
            min = Math.min(temp, min);
        }
        visited[curIndex] = false;
        return min;
    }


    // 判断是否除0外，其余站点都已经经过
    public static boolean judge(boolean[] visited) {
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

}