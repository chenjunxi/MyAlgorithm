package com.leecode;

import java.util.ArrayList;

/*
 *
 * 反转元音字母
 * */
public class leecode345 {
    public static void main(String[] args) {
        String s = "leetcode";

        ArrayList<Character> list = new ArrayList<>();

        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');

        int left = 0, right = s.length() - 1;

        char[] chars = s.toCharArray();

        while (left < right) {

            char aChar = chars[left];
            char bChar = chars[right];

            if (list.contains(aChar) && list.contains(bChar)) {
                //swap
                left++;
                right--;
            } else if (list.contains(aChar)) {
                right--;
            } else if (list.contains(bChar)) {
                left++;
            }
        }


    }


}
