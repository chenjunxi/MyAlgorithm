package com.leecode;

//最长回文子串
public class leecode005 {
    public static void main(String[] args) {

    }

    //中心扩散，记录最大长度和最左的下标即可
    public String longestPalindrome1(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);

    }


    public String longestPalindrome(String s) {

        if (s.length() == 1) {
            return s;
        }

        int max = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {

                String substring = s.substring(i, j);

                if (substring.length() > max && check(substring)) {
                    max = substring.length();
                    ans = substring;
                }
            }
        }

        return ans;
    }

    public boolean check(String str) {

        StringBuilder sb = new StringBuilder(str);

        return sb.reverse().toString().equals(str);
    }
}
