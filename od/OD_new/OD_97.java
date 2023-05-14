package com.od.OD.OD130;

import java.util.Scanner;

/*
严格递增字符串
字符串由A或B组成
求满足严格递增的字符串的最小修改次数
AABBA
输出1 修改一次得到AABBB就是严格递增字符串
AAABAABBBBAAAAAABBB
输出5
* */
class OD_97 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();

        int min = 0;
        int countB = 0;

        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == 'B'){
                //假设之前的子字符串经过修改已满足要求，当前位置的B并不会使字典序变化，只统计B的个数
                countB ++;
            }
            if (string.charAt(i) == 'A') {
                //方案1 : 把所有之前的B改为A
                int candidate1 = countB;

                //方案2：假设在当前位置以前的子字符串经过修改已满足要求，把当前位置的A改为B,即动态编程思想
                int candidate2 = min + 1;

                min = Math.min( candidate1, candidate2);
            }
        }

        System.out.println(min);
    }

}