package com.od.OD.OD130;


import java.util.Scanner;

/*查重复代码
 *
 * */
//返回两个字符串最大子字符串
public class OD_50 {
    public static void main(String[] args) {
//        String text1 = "private_coid_meth";
//        String text2 = "publie_coid_meth";

        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String text2 = scanner.nextLine();

        String minLen = text1.length() > text2.length() ? text2 : text1;
        String maxLen = minLen.length() == text1.length() ? text2 : text1;

        String res = "";
        int left = 0, right = 0;
        while (right < minLen.length()) {

            String substring = minLen.substring(left, right + 1);

            if (maxLen.contains(substring) && substring.length() > res.length()) {
                res = substring;
            } else {
                left++;
            }
            right++;
        }

        System.out.println(res);
    }
}
