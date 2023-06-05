package com.od.B.fenshu100;

import java.util.Scanner;
/*
* 数列描述
*
* */
public class OD19 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(n == 0 ? "1" : getRes(n));

    }

    public static StringBuffer getRes(int n) {

        if (n == 1) {
            return new StringBuffer("11");  //因为当n=0的时候只有一位数，无法进行比较
        }
        StringBuffer s = getRes(n - 1);
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        int count = 1;  //连续相同数字的计数
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;    //数字相同且连续则+1
            } else {
                sb.append(count);
                sb.append(s.charAt(i - 1));
                count = 1;    //重置下计数
            }
            if (i == len - 1) {   //最后一位
                sb.append(count);
                sb.append(s.charAt(i));
            }
        }
        return sb;
    }


}
