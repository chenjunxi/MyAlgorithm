package com.od.OD.OD130;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/*
*云短信平台优惠活动
*
* */
public class OD_30 {
    public static int min_num;

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int money = Integer.parseInt(in.nextLine());
        //转为数组
        List<Integer> topup_info = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] dp = new int[money + 1];

        for (int i = 0; i <= topup_info.size(); i++) {
            for (int j = 0; j <= money; j++) {
                if (!(i == 0 || j == 0 || j < i)) {
                    dp[j] = Math.max(dp[j], dp[j - i] + topup_info.get(i - 1));
                }
            }
        }
        System.out.println(dp[money]);

    }
}
