package com.od.OD.OD100;

public class OD_04 {
    public static boolean flag = true;

    public static void main(String[] args) {

        //从四边界入口 上右下左，即顺时针搜索
        //如果是一个岛就感染为X,避免重复计算

        char[][] dp = {{'O'}};

        int N = dp.length;
        int M = dp[0].length;
        int i, j;


        //特殊情况
        if (N == 1 && M == 1) {
            if (dp[0][0] == 'O') {
                System.out.println(0 + " " + 0 + " " + 1);
            }
        }

//  上侧从左到右
        for (j = 0; j < M - 1; j++) {
            char c = dp[0][j];
            if (c == 'O') {
                int infect = infect(dp, 0, j, N, M, true);
                if (flag) {
                    System.out.println(0 + " " + j + " " + infect);
                } else {
                    flag = true;
                }
            }

        }


        //右侧从上到下
        for (i = 0; i < N - 1; i++) {
            char c = dp[i][j];
            if (c == 'O') {
                int infect = infect(dp, i, j, N, M, true);
                if (flag) {
                    System.out.println(i + " " + (j) + " " + infect);

                } else {
                    flag = true;
                }
            }

        }

        //下侧从右到左
        for (; j >= 1; j--) {
            char c = dp[i][j];
            if (c == 'O') {
                int infect = infect(dp, i, j, N, M, true);
                if (flag) {
                    System.out.println((i) + " " + j + " " + infect);

                } else {
                    flag = true;
                }
            }

        }

        //左侧从下到上
        for (; i >= 1; i--) {
            char c = dp[i][j];
            if (c == 'O') {
                int infect = infect(dp, i, j, N, M, true);
                if (flag) {
                    System.out.println(i + " " + j + " " + infect);

                } else {
                    flag = true;
                }
            }

        }

        //打印
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                System.out.print(dp[a][b] + "\t");
            }
            System.out.println();
        }

    }

    //感染搜索过的值，避免后面重复计算
    // 判断是否成功，若成功则返回数量有效
    public static int infect(char[][] dp, int i, int j, int N, int M, boolean rukou) {
        if (i < 0 || j < 0 || i >= N || j >= M || dp[i][j] != 'O') { //边界条件
            return 0;
        }

        if (!rukou) { //非入口出现值为O，表示flag=false就判断为不是单入口区域
            if (i == 0 && dp[i][j] == 'O') flag = false;
            if (j == 0 && dp[i][j] == 'O') flag = false;
            if (j == M - 1 && dp[i][j] == 'O') flag = false;
            if (i == N - 1 && dp[i][j] == 'O') flag = false;
        }

        dp[i][j] = 'X'; //感染
        int count = 1;

        //左右下上递归感染
        int a = infect(dp, i - 1, j, N, M, false);
        int b = infect(dp, i + 1, j, N, M, false);
        int c = infect(dp, i, j - 1, N, M, false);
        int d = infect(dp, i, j + 1, N, M, false);


        return count + a + b + d + c;
    }
}
