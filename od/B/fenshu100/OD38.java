package com.od.B.fenshu100;

import java.util.Scanner;

public class OD38 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");

        int len = s.length;
        int count = 0;

        Boolean isAll;  //是否全为英文
        for (int i = 0; i < len; i++) {
            isAll = true;
            String str = s[i];
            int strLen = str.length(); //当前字符串长度
            if (strLen < 4) {    //字符串小于4不符合
                continue;
            }
            for (int j = 0; j < strLen; j++) {
                if (!Character.isLetter(str.charAt(j))) {    //是否有非英文
                    isAll = false;
                }
            }
            if (isAll) {
                str = reverseStr(str);  //全英文则反转
            }
            for (int j = 0; j <= strLen - 4; j++) {
                if (isKYJ(str.substring(j, j + 4))) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    public static String reverseStr(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return reverseStr(s.substring(1)) + s.substring(0, 1);
    }

    public static boolean isKYJ(String str) {

        String yuanyin = "aeiou";
        String fuyin = "bcdfghjklmnpqrstvwxyz";

        String s1 = String.valueOf(str.charAt(0));
        String s2 = String.valueOf(str.charAt(1));
        String s3 = String.valueOf(str.charAt(2));
        String s4 = String.valueOf(str.charAt(3));

        if (fuyin.contains(s1)    //非元音即辅音
                && yuanyin.contains(s2)
                && fuyin.contains(s3) && !s3.equals("r")
                && s4.equals("e")) {
            return true;
        }
        return false;
    }
}
