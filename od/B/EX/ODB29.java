package com.od.B.EX;

import java.util.*;

public class ODB29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input_str = in.next();
        int length = in.nextInt();

        //乱序字符串中各字符分布
        HashMap<Character, Integer> origin_char_map = new HashMap<>();
        for (int i = 0; i < input_str.length(); i++) {
            char c = input_str.charAt(i);
            origin_char_map.put(c, origin_char_map.getOrDefault(c, 0) + 1);
        }

        //滑动窗口中各字符分布
        HashMap<Character, Integer> window_char_map = new HashMap<>();
        for (int i = 1; i <= length; i++) {
            countNumChar(i + "", window_char_map, true);
        }


        if (cmp(origin_char_map, window_char_map)) {
            System.out.println(0);
            return;
        }

        for (int i = 2; i <= 1000 - length + 1; i++) {
            String remove = i - 1 + "";
            countNumChar(remove, window_char_map, false);

            String add = i + length - 1 + "";
            countNumChar(add, window_char_map, true);

            if (cmp(origin_char_map, window_char_map)) {
                System.out.println(i);
                return;
            }
        }
        return;
    }

    public static void countNumChar(String num, HashMap<Character, Integer> window_char_map, boolean isAdd) {
        for (int j = 0; j < num.length(); j++) {
            char c = num.charAt(j);
            window_char_map.put(c, window_char_map.getOrDefault(c, 0) + (isAdd ? 1 : -1));
        }
    }

    public static boolean cmp(HashMap<Character, Integer> origin_char_map, HashMap<Character, Integer> window_char_map) {
        for (Character c : origin_char_map.keySet()) {
            if (!window_char_map.containsKey(c) || window_char_map.get(c) - origin_char_map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}
