package com.leecode;

import java.util.Arrays;

/*
*
双指针，反转字符串

* */
public class leecode151_2 {
    public static void main(String[] args) {

        String s = " hello world!  ";

        char[] chars = s.toCharArray();

        chars = removeSpace(chars);

        reverse(chars, 0, chars.length - 1);
        System.out.println(new String(chars));
        reverseWord(chars);
        System.out.println(new String(chars));
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
