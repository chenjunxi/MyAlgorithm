package com.od.B.fenshu100;

import java.util.Scanner;

/*
 * 相对开音节
 *
 相对开音=辅音+元音(aeiou)+辅音(不含r)+e,如bike，cakeke这个算两个cake、keke

ekam a ekac
输出2

思路：遍历每个字符串，长度小于4就continue
判断字符串是否包含非字母，小技巧：String[] split = str.split("[a-zA-Z]") 数组大小为0就没包含其他字符
4个长度截取字符串，判断是否是相对开音节
 * */


public class OD38 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");

        int len = s.length;
        int count = 0;

        Boolean isAll;  //是否全为英文
        for (int i = 0; i < len; i++) {

            String str = s[i];
            int strLen = str.length(); //当前字符串长度
            if (strLen < 4) {    //字符串小于4不符合
                continue;
            }
            String[] split = str.split("[a-zA-Z]");

            if (split.length == 0) {
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
        StringBuilder ssb = new StringBuilder(s);
        ssb.reverse();
        return ssb.toString();
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
