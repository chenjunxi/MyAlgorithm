package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
* 字符串比较
求两个字符串的最大连续子串长度
|A[i]-B[i]|之和小于等于给定的值
xxcdefg
cdefghi
5
输出2
xxaaabbb
cdbbdaaa

思路遍历AB字符串，同位置比较
小于给定值，就添加为子串。
* */
public class OD05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int n = scanner.nextInt();
        int len = s1.length();


        //遍历两个字符串，把差值存放在数组中
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            ints[i] = Math.abs(a - b);
        }


        //剩下的事就是求数组中最长连续子串之和小于等于n
        int max = -1;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] >= n) continue;
            int temp = ints[i];
            for (int j = i + 1; j < ints.length; j++) {
                temp += ints[j];
                if (temp <= n) {
                    max = Math.max(j - i + 1, max);
                } else {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(ints));
        System.out.println(max);

    }

    private static void demo(String s1, String s2, int n) {
        int max = 0;
        int length = 0;
        List<Integer> list = new ArrayList<>();     //用列表存放符合要求的数

        list.add(Math.abs(s1.charAt(0) - s2.charAt(0)));      //假设第一个字母就符合要求
        int count = list.get(0);        //第一个字母ASCII码之差的绝对值

        for (int i = 1; i < s1.length(); i++) {

            int temp = Math.abs(s1.charAt(i) - s2.charAt(i));

            list.add(temp);     //直接将本次的ASCII码之差的绝对值添加进列表
            count += Math.abs(temp);      //求最新的绝对值和

            if (count <= n) {
                length = list.size();       //若符合要求则最长的为列表的长度
            } else {
                count -= list.get(0);   //不符合则减去并删除列表第一个数
                list.remove(0);
            }
            max = Math.max(length, max);
        }

        System.out.println(max);
    }
}
