package com.leecode;

public class leecode005 {
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {

        if (s.length()==1){
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
