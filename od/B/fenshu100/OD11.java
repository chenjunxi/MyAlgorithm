package com.od.B.fenshu100;

import akka.stream.impl.fusing.Scan;

import java.util.Arrays;
import java.util.Scanner;

/*
* 喊7游戏 简单题
* 到达7的倍数或者数字包含7就喊过
* 给出喊过的数量和位置，是打乱的，要求恢复正确的位置
0 1 0   1代表只有一次过，也就是7
输出1 0 0

思路：报数%数组大小-1=数组下标
先统计喊过有多少个，然后找出符合要求的前多少个数字 7 14 17 21 ……
int[7%数组大小-1]++
* */
public class OD11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        int[] ints = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int count = Arrays.stream(ints).sum();

        int length = ints.length;
        int[] nums = new int[length];

        for (int i = 7; i <= 200; i++) {
            if (i % 7 == 0 || String.valueOf(i).contains("7")) {
                nums[i % length - 1]++;
                count--;
            }
            if (count == 0) break;
        }
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                System.out.print(nums[i]);
                break;
            }
            System.out.print(nums[i] + " ");

        }
    }

    private static void demo() {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int len = s.length;

        int[] ints = new int[len];

        int num = 0;
        for (int i = 0; i < len; i++) {
            num += Integer.valueOf(s[i]);     //计算出符合的次数
        }
        int step = 7;   //直接从7开始
        while (num > 0) {
            if (step % 7 == 0 || String.valueOf(step).contains("7")) {
                ints[(step - 1) % len]++;      //同过数组长度算出符合的下标
                num--;      //符合的次数递减
            }
            step++;     //报数的次数递增
        }

        String res = "";
        for (int i = 0; i < len; i++) {
            res += String.valueOf(ints[i]);
            if (i == len - 1) {
                break;
            }
            res += " ";
        }

        System.out.println(res);
    }

}
