package com.od.OD.OD130;

import java.util.Scanner;

//最左侧冗余覆盖子串
//滑动窗口，用数组记录字母的数量，向右滑动，每一次移到减去左边的字母出现的次数，加上右边新进的字母数量
// 判断覆盖原理：相同字符串，截取字符串的字母数量都是大于等于s1出现的次数。
public class OD_28 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int len1 = s1.length();
        int len2 = s2.length();

        int k = Integer.valueOf(sc.nextLine());
        int subLen = len1 + k;

        if (len2 < subLen) {
            System.out.println(-1);
            return;
        }

        int[] zimuCount = new int[26];

        String substring = s2.substring(0, subLen);
        for (char c : substring.toCharArray()) {
            zimuCount[c - 'a']++;
        }

        int[] s1zimuCount = new int[26];
        for (char c : s1.toCharArray()) {
            s1zimuCount[c - 'a']++;
        }

        int leftChar = s2.charAt(0);

        int res = -1;
        for (int i = 0; i < len2 - subLen+1; i++) {
            char rightChar = s2.charAt(subLen + i - 1);
            if (i > 0) {
                zimuCount[leftChar - 'a']--;
                zimuCount[rightChar - 'a']++;
                leftChar = s2.charAt(i);
            }

            if (isCover(zimuCount, s1zimuCount)) {
                res = i;
                break;
            }
        }

        System.out.println(res);


    }

    //判断字母次数
    public static boolean isCover(int[] arr, int[] s1) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] < s1[i]) {
                return false;
            }
        }

        return true;
    }


}
