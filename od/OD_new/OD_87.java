package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
/*
* 上班之路
1)”.” - 空地，可以达到;
2)”*” - 路障，不可达到;
3)"S” - Jungle的家;
4)”T” - 公司.

* */
class OD_87 {
    private static final int[][] directions = {{0, 1, 1}, {0, -1, 2}, {1, 0, 3}, {-1, 0, 4}};
    private static int t, c, n, m;
    private static String[][] matrix;

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        c = in.nextInt();

        n = in.nextInt();
        m = in.nextInt();

        matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = in.next().split("");
        }

        //遍历矩阵,找到起点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("S".equals(matrix[i][j])) {
                    HashSet<Integer> road = new HashSet<>();
                    road.add(i * m + j);
                    if (dfs(road, i, j, 0, 0, 0)) {
                        System.out.println("YES");
                        return;
                    } else {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
        return;
    }

    public static boolean dfs(HashSet<Integer> road, int x, int y, int ut, int uc, int last_direct) {
        // 找到目的地
        if ("T".equals(matrix[x][y])) {
            return true;
        }

        // 有四个方向选择走下一步
        for (int[] direction : directions) {
            int direct = direction[2];
            int new_x = x + direction[0];
            int new_y = y + direction[1];

            // 转向+破壁标记
            boolean turn_flag = false;
            boolean break_flag = false;

            // 越界 + 是否当前点已访问判断
            if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m) {
                if (road.contains(new_x * m + new_y)) continue;
                //转向+破壁判断
                if (last_direct != 0 && last_direct != direct) {
                    // 转向次数已用尽
                    if (ut + 1 > t) {
                        continue;
                    }
                    turn_flag = true;
                }

                if ("*".equals(matrix[new_x][new_y])) {
                    // 破壁次数已用尽
                    if (uc + 1 > c) {
                        continue;
                    }
                    break_flag = true;
                }
                road.add(new_x * m + new_y);
                // 可到达目的地T, 返回true
                if (dfs(road, new_x, new_y, ut + (turn_flag ? 1 : 0), uc + (break_flag ? 1 : 0), direct)) {
                    return true;
                }
                road.remove(new_x * m + new_y);
            }
        }
        return false;
    }

}
