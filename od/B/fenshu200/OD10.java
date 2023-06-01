package com.od.B.fenshu200;

import java.util.Scanner;

public class OD10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] map = new int[300][300];

        int line = 0;
        while (sc.hasNext()) {
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                map[line][i] = Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            line++;
        }

        // bfs
        int result = 0;
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 300; j++) {
                result = Math.max(result, bfs(0, i, j, map));
            }
        }

        System.out.println(result);
    }

    public static int bfs(int result, int x, int y, int[][] map) {

        if (map[x][y] == 0) {
            // 不可挖掘
            return result;
        }

        result += map[x][y];
        //已挖掘的置为0
        map[x][y] = 0;
        //向上
        if (can(x - 1, y, map)) {
            result = bfs(result, x - 1, y, map);
        }
        //向下
        if (can(x + 1, y, map)) {
            result = bfs(result, x + 1, y, map);
        }
        //向左
        if (can(x, y - 1, map)) {
            result = bfs(result, x, y - 1, map);
        }
        //向右
        if (can(x, y + 1, map)) {
            result = bfs(result, x, y + 1, map);
        }

        return result;
    }

    public static boolean can(int x, int y, int[][] map) {

        if (x < 0 || x == 300) {
            return false;
        }
        if (y < 0 || y == 300) {
            return false;
        }
        //大于0才能挖掘
        return map[x][y] > 0;
    }
}
