package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/*
* 最长回文字符串
*给定一个字符串，构造最长的回文串，有多个的时候返回字典序最小的
ABabBabA
ABabbaBA
思路就是：回文串分奇数个偶数个 AbA 和 ABBA
分两种情况比较，而且出现次数是偶数或偶数加一个奇数

* */
public class OD_113 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine();

        HashMap<Character, Integer> char_count = new HashMap<>();

        for (int i = 0; i < input_str.length(); i++) {
            char c = input_str.charAt(i);
            if (char_count.containsKey(c)) {
                char_count.put(c, char_count.get(c) + 1);
            } else {
                char_count.put(c, 1);
            }
        }

        //偶数、奇数组合
        ArrayList<Character> even_chars = new ArrayList<>();
        ArrayList<Character> odd_chars = new ArrayList<>();

        for (char c : char_count.keySet()) {
            int count = char_count.get(c);
            if (count >= 2) {
                for (int i = 0; i < count / 2; i++) {
                    even_chars.add(c);
                }
            }

            //两种情况，第一种是超过2 的奇数,一个是出现次数为1
            if (count % 2 != 0) {
                odd_chars.add(c);
            }
        }

        even_chars.sort((a, b) -> a - b);
        String left_str = even_chars.stream().map(Object::toString)
                .collect(Collectors.joining(""));

        String mid_str = "";
        if (odd_chars.size() > 0) {
            odd_chars.sort((a, b) -> a - b);
            mid_str = odd_chars.get(0) + "";
        }
        even_chars.sort((a, b) -> b - a);
        String right_str = even_chars.stream().map(Object::toString)
                .collect(Collectors.joining(""));
        System.out.println(left_str + mid_str + right_str);
    }
}
