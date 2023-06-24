package com.leecode;

import java.util.Arrays;

/*
*
双指针，反转字符串

* */
public class leecode151_2 {
    public static void main(String[] args) {

        String s = " chen junxi hello world!  ";

        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        int right = s.length() - 1;
        int left = 0;

        //清除左右两侧的0
        while (s.charAt(right) == ' ') {
            right--;
        }
        while (s.charAt(left) == ' ') {
            left++;
        }

        while (right >= left) {

            int index = right;
            //找到要存储的单词
            while (index >= left && s.charAt(index) != ' ') {
                index--;
            }
            //存到StringBuilder
            sb.append(s.substring(index + 1, right + 1));
            if (index > left) {
                sb.append(' ');
            }
            //找下一个单词
            while (index >= left && s.charAt(index) == ' ') {
                index--;
            }
            right = index;

        }
        return sb.toString();

    }


    private static void reverse(char[] chars, int i, int j) {

        while (i < j) {
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
            i++;
            j--;
        }
    }

    private static void reverseWord(char[] chars) {

        int index = 0;
        for (int i = 0; i <= chars.length; i++) {

            if (i == chars.length || chars[i] == ' ') {
                reverse(chars, index, i - 1);
                index = i + 1;
            }
        }


    }

    private static char[] removeSpace(char[] chars) {

        int slow = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {

                if (slow != 0) {
                    chars[slow++] = ' ';
                }
                while (i < chars.length && chars[i] != ' ') {
                    chars[slow++] = chars[i++];
                }
            }
        }

        char[] newChar = new char[slow];
        System.arraycopy(chars, 0, newChar, 0, slow);
        return newChar;

    }
}
