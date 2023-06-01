package com.od.B.fenshu200;

import java.util.Scanner;

public class OD02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int m = sc.nextInt();
        //截取字符的右边界
        int l = m + 1;
        int index = 0;
        String res = "";

        while (res.length() < s.length() - m) {
            //求出第一个数字的最小值
            String str = s.substring(index, l);
            int min = Integer.MAX_VALUE;
            int len = str.length();
            int[] ints = new int[len];
            for (int i = 0; i < len; i++) {
                //char转换成int
                int temp = str.charAt(i) - '0';
                //放入数组求出下标
                ints[i] = temp;
                //第一位不能为0（如没有要求可以删掉）
                if (res == "" && temp == 0) {
                    continue;
                }
                min = Math.min(min, temp);
            }
            res += String.valueOf(min);

            for (int i = 0; i < len; i++) {
                if (ints[i] == min) {
                    //求出第一个最小值的下标然后去截取循环获取最小值
                    index += i;
                    break;
                }
            }
            index++;
            //数字要往后移一位
            l++;
        }
        System.out.println(res);
    }

}
