package com.od.B.EX;

import java.util.*;

/*
*打开监控器
监控器打开条件：
1.本身车位停有车的时候打开。
2.如果本身车位没有停车，但是其四面停有车，也要打开。
3 3
0 0 0
0 1 0
0 0 0
输出5
坐标(0,1)本身没停车，但是其下方停车了，所以(0,1)处的监控器需要打开
依次类推
3 3
0 0 0
0 1 0
0 1 0

其实就是求二维数组中，值为的四面有多少个0，然后加上本

* */
public class ODB02 {
    public static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = in.nextInt();
            }
        }

        int result = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (dp[x][y] == 1) {
                    result++;
                    result += dfs(dp, x - 1, y, m, n);
                    result += dfs(dp, x + 1, y, m, n);
                    result += dfs(dp, x, y - 1, m, n);
                    result += dfs(dp, x, y + 1, m, n);
                }

            }
        }
        System.out.println(result);

    }

    private static int dfs(int[][] dp, int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n || dp[x][y] == 1) {
            return 0;
        }
        return 1;
    }
}
