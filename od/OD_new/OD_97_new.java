package com.od.OD.OD130;

import java.util.Scanner;
/*
严格递增字符串
* */
class OD_97_new {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine();

        System.out.println(minFlipsMonoIncr(input_str));
    }
    public static int minFlipsMonoIncr(String s) {
        int n = s.length();
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int dp0New = dp0, dp1New = Math.min(dp0, dp1);
            if (c == 'B') {
                dp0New++;
            } else {
                dp1New++;
            }
            dp0 = dp0New;
            dp1 = dp1New;
        }
        return Math.min(dp0, dp1);
    }

}