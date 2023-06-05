package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 字符串加密
使用动态dp保存偏移量
1
xy

2
xy
abcde
* */
public class OD23 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String zimu = "abcdefghijklmnopqrstuvwxyz";
        int n = sc.nextInt();
        sc.nextLine();
        List<StringBuffer> list = new ArrayList<>();

        int[] dp = new int[50];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        for (int i = 3; i < 50; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < n; i++) {

            String s = sc.nextLine();
            StringBuffer sb = new StringBuffer();
            int len = s.length();

            for (int j = 0; j < len; j++) {
                int pianyi = dp[j];
                int index = (zimu.indexOf(s.charAt(j)) + pianyi) % 26;    //需要取余，防止pianyi值过大
                sb.append(zimu.charAt(index));
            }

            list.add(sb);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }



}
